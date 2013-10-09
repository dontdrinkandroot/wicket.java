package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum ButtonSize implements CssClass {

	EXTRA_SMALL("btn-xs"),
	SMALL("btn-sm"),
	LARGE("btn-lg");

	private String classString;


	private ButtonSize(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}
}
