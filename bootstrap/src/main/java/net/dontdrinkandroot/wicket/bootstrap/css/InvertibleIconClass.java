package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


/**
 * Holds a CssClass that refers to an item CssClass and also provides the ability to invert this
 * icon, so it can be used to fully specify the icon.
 * 
 * @author Philip W. Sorst<philip@sorst.net>
 */
public class InvertibleIconClass implements CssClass {

	private final CssClass iconClass;

	private boolean inverted = false;


	public InvertibleIconClass(CssClass iconClass) {

		this.iconClass = iconClass;
	}


	public InvertibleIconClass(CssClass iconClass, boolean inverted) {

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


	public InvertibleIconClass invert() {

		this.inverted = !this.inverted;
		return this;
	}


	public boolean isInverted() {

		return this.inverted;
	}

}
