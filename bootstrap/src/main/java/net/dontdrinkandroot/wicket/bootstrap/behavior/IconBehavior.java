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


public class IconBehavior extends AbstractTransformerBehavior {

	private final static Pattern PATTERN = Pattern.compile("(<.*?>)(.*)(</.*?>)", Pattern.DOTALL);

	private IModel<IconClass> beforeIconModel;

	private boolean beforeIconInverted = false;

	private IModel<IconClass> afterIconModel;

	private boolean afterIconInverted = false;


	public IconBehavior setBeforeIcon(IconClass beforeIcon, boolean inverted) {

		this.beforeIconModel = Model.of(beforeIcon);
		this.beforeIconInverted = inverted;

		return this;
	}


	public IconBehavior setAfterIcon(IconClass afterIcon, boolean inverted) {

		this.afterIconModel = Model.of(afterIcon);
		this.afterIconInverted = inverted;

		return this;
	}


	protected IModel<IconClass> getBeforeIconModel() {

		return this.beforeIconModel;
	}


	protected IModel<IconClass> getAfterIconModel() {

		return this.afterIconModel;
	}


	protected boolean isBeforeIconInverted() {

		return this.beforeIconInverted;
	}


	protected boolean isAfterIconInverted() {

		return this.afterIconInverted;
	}


	@Override
	public CharSequence transform(Component component, CharSequence output) throws Exception {

		if ((this.getBeforeIconModel() == null || this.getBeforeIconModel().getObject() == null)
				&& (this.getAfterIconModel() == null || this.getAfterIconModel().getObject() == null)) {
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

		StringBuffer before = new StringBuffer();
		if (this.getBeforeIconModel() != null && this.getBeforeIconModel().getObject() != null) {
			before.append("<i class=\"" + this.getBeforeIconModel().getObject().getClassString());
			if (this.isBeforeIconInverted()) {
				before.append(" " + BootstrapCssClass.ICON_WHITE.getClassString());
			}
			before.append("\">");
			before.append("</i> ");
		}

		StringBuffer after = new StringBuffer();
		if (this.getAfterIconModel() != null && this.getAfterIconModel().getObject() != null) {
			after.append(" <i class=\"" + this.getAfterIconModel().getObject().getClassString());
			if (this.isAfterIconInverted()) {
				after.append(" " + BootstrapCssClass.ICON_WHITE.getClassString());
			}
			after.append("\">");
			after.append("</i>");
		}

		return new StringBuffer(open).append(before).append(body).append(after).append(close);
	}
}
