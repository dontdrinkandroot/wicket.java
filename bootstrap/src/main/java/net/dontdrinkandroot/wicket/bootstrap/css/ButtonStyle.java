package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum ButtonStyle implements CssClass {

	DANGER("btn-danger"),
	INFO("btn-info"),
	INVERSE("btn-inverse"),
	LINK("btn-link"),
	PRIMARY("btn-primary"),
	SUCCESS("btn-success"),
	WARNING("btn-warning");

	private String classString;


	private ButtonStyle(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}
}
