package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum FontAwesomeIconClass implements CssClass {

	ASTERISK("fa-asterisk"),
	CHECK("fa-check"),
	LOCK("fa-lock"),
	PENCIL("fa-pencil"),
	PLUS("fa-plus"),
	POWER_OFF("fa-power-off"),
	TRASH("fa-trash");

	private final String classString;


	private FontAwesomeIconClass(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}

}
