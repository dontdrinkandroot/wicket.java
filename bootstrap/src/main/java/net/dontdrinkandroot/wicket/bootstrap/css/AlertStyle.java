package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum AlertStyle implements CssClass {

	DANGER("alert-danger"),
	INFO("alert-info"),
	SUCCESS("alert-success"),
	WARNING("alert-warning");

	private String classString;


	private AlertStyle(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}
}
