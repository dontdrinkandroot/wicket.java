package net.dontdrinkandroot.wicket.bootstrap.behavior;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.IconClass;

import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.transformer.AbstractTransformerBehavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;


/**
 * Prepends and/or appends an Icon to the body of the attached component.
 */
public class IconBehavior extends AbstractTransformerBehavior {

	private final static Pattern PATTERN = Pattern.compile("(<.*?>)(.*)(</.*?>)", Pattern.DOTALL);

	private final IModel<IconClass> beforeIconModel = new Model<IconClass>();

	private boolean beforeIconInverted = false;

	private final IModel<IconClass> afterIconModel = new Model<IconClass>();

	private boolean afterIconInverted = false;


	public IconBehavior() {

	}


	public IconBehavior(IconClass beforeIcon, boolean inverted) {

		this.getBeforeIconModel().setObject(beforeIcon);
		this.beforeIconInverted = inverted;
	}


	@Override
	public CharSequence transform(Component component, CharSequence output) throws Exception {

		boolean hasBeforeIcon = this.getBeforeIconModel() != null && this.getBeforeIconModel().getObject() != null;
		boolean hasAfterIcon = this.getAfterIconModel() != null && this.getAfterIconModel().getObject() != null;

		if (!hasBeforeIcon && !hasAfterIcon) {
			return output;
		}

		Matcher matcher = IconBehavior.PATTERN.matcher(output);
		if (!matcher.matches()) {
			throw new WicketRuntimeException(String.format(
					"IconBehavior applied to a component that does not have a body: %s",
					output));
		}

		String open = matcher.group(1);
		String body = matcher.group(2);
		String close = matcher.group(3);

		boolean isBodyEmpty = Strings.isEmpty(body);

		StringBuffer before = new StringBuffer();
		if (this.getBeforeIconModel() != null && this.getBeforeIconModel().getObject() != null) {
			before.append("<i class=\"" + this.getBeforeIconModel().getObject().getClassString());
			if (this.isBeforeIconInverted()) {
				before.append(" " + BootstrapCssClass.ICON_WHITE.getClassString());
			}
			before.append("\">");
			before.append("</i>");
			if (!isBodyEmpty || hasAfterIcon) {
				before.append(" ");
			}
		}

		StringBuffer after = new StringBuffer();
		if (this.getAfterIconModel() != null && this.getAfterIconModel().getObject() != null) {
			if (!isBodyEmpty) {
				after.append(" ");
			}
			after.append("<i class=\"" + this.getAfterIconModel().getObject().getClassString());
			if (this.isAfterIconInverted()) {
				after.append(" " + BootstrapCssClass.ICON_WHITE.getClassString());
			}
			after.append("\">");
			after.append("</i>");
		}

		return new StringBuffer(open).append(before).append(body).append(after).append(close);
	}


	public IconClass getBeforeIcon() {

		return this.getBeforeIconModel().getObject();
	}


	public IconBehavior setBeforeIcon(IconClass beforeIcon, boolean inverted) {

		this.getBeforeIconModel().setObject(beforeIcon);
		this.beforeIconInverted = inverted;

		return this;
	}


	public IconClass getAfterIcon() {

		return this.getAfterIconModel().getObject();
	}


	public IconBehavior setAfterIcon(IconClass afterIcon, boolean inverted) {

		this.getAfterIconModel().setObject(afterIcon);
		this.afterIconInverted = inverted;

		return this;
	}


	public boolean isBeforeIconInverted() {

		return this.beforeIconInverted;
	}


	public boolean isAfterIconInverted() {

		return this.afterIconInverted;
	}


	protected IModel<IconClass> getBeforeIconModel() {

		return this.beforeIconModel;
	}


	protected IModel<IconClass> getAfterIconModel() {

		return this.afterIconModel;
	}
}
