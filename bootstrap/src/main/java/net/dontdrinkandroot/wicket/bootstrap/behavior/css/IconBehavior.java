package net.dontdrinkandroot.wicket.bootstrap.behavior.css;

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

	private final static Pattern PATTERN = Pattern.compile("(<.*?>)(.*)(</.*?>)");

	private IModel<IconClass> beforeIconModel;

	private boolean beforeInverted = false;

	private IModel<IconClass> afterIconModel;

	private boolean afterInverted = false;


	public IconBehavior setBeforeIcon(IconClass beforeIcon, boolean inverted) {

		this.beforeIconModel = Model.of(beforeIcon);
		this.beforeInverted = inverted;

		return this;
	}


	public IconBehavior setAfterIcon(IconClass afterIcon, boolean inverted) {

		this.afterIconModel = Model.of(afterIcon);
		this.afterInverted = inverted;

		return this;
	}


	protected IModel<IconClass> getBeforeIconModel() {

		return this.beforeIconModel;
	}


	protected IModel<IconClass> getAfterIconModel() {

		return this.afterIconModel;
	}


	@Override
	public CharSequence transform(Component component, CharSequence output) throws Exception {

		Matcher matcher = IconBehavior.PATTERN.matcher(output);
		if (!matcher.matches()) {
			throw new WicketRuntimeException("IconBehavior applied to a component that does not have a body");
		}

		String open = matcher.group(1);
		String body = matcher.group(2);
		String close = matcher.group(3);

		StringBuffer before = new StringBuffer();
		if (this.getBeforeIconModel() != null && this.getBeforeIconModel().getObject() != null) {
			before.append("<i class=\"" + this.getBeforeIconModel().getObject().getClassString());
			if (this.beforeInverted) {
				before.append(" " + BootstrapCssClass.ICON_WHITE.getClassString());
			}
			before.append("\">");
			before.append("</i> ");
		}

		StringBuffer after = new StringBuffer();
		if (this.getAfterIconModel() != null && this.getAfterIconModel().getObject() != null) {
			after.append(" <i class=\"" + this.getAfterIconModel().getObject().getClassString());
			if (this.afterInverted) {
				after.append(" " + BootstrapCssClass.ICON_WHITE.getClassString());
			}
			after.append("\">");
			after.append("</i>");
		}

		return new StringBuffer(open).append(before).append(body).append(after).append(close);
	}
}
