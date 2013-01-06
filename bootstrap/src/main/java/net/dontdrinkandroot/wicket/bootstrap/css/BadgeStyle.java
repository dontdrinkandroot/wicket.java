package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum BadgeStyle implements CssClass {

	IMPORTANT("badge-important"),
	INFO("badge-info"),
	INVERSE("badge-inverse"),
	SUCCESS("badge-success"),
	WARNING("badge-warning");

	private String classString;


	private BadgeStyle(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}
}
