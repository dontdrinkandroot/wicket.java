package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public class InvertibleIconClass implements CssClass {

	private final IconClass iconClass;

	private boolean inverted = false;


	public InvertibleIconClass(IconClass iconClass) {

		this.iconClass = iconClass;
	}


	public InvertibleIconClass(IconClass iconClass, boolean inverted) {

		this.iconClass = iconClass;
		this.inverted = inverted;
	}


	@Override
	public String getClassString() {

		if (this.iconClass == null) {
			return null;
		}

		StringBuffer cssClassBuffer = new StringBuffer(this.iconClass.getClassString());
		if (this.inverted) {
			cssClassBuffer.append(" ");
			cssClassBuffer.append(BootstrapCssClass.ICON_WHITE.getClassString());
		}

		return cssClassBuffer.toString();
	}


	public void invert() {

		this.inverted = !this.inverted;
	}


	public boolean isInverted() {

		return this.inverted;
	}

}
