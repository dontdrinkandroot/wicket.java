package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum ButtonSize implements CssClass {

	MINI("btn-mini"),
	SMALL("btn-small"),
	LARGE("btn-large");

	private String classString;


	private ButtonSize(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}
}
