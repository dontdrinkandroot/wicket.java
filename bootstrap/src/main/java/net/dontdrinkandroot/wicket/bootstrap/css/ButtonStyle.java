package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum ButtonStyle implements CssClass {

	DEFAULT("btn-default"),
	PRIMARY("btn-primary"),
	SUCCESS("btn-success"),
	INFO("btn-info"),
	WARNING("btn-warning"),
	DANGER("btn-danger"),
	LINK("btn-link");

	private String classString;


	private ButtonStyle(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}
}
