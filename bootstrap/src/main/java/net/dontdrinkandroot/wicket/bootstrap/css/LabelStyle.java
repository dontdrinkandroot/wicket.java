package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum LabelStyle implements CssClass {

	IMPORTANT("label-important"),
	INFO("label-info"),
	INVERSE("label-inverse"),
	SUCCESS("label-success"),
	WARNING("label-warning");

	private String classString;


	private LabelStyle(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}
}
