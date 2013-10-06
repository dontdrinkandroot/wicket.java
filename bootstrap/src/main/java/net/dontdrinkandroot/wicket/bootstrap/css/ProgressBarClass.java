package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum ProgressBarClass implements CssClass {

	INFO("progress-bar-info"),
	SUCCESS("progress-bar-success"),
	WARNING("progress-bar-warning"),
	DANGER("progress-bar-danger");

	private String classString;


	private ProgressBarClass(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}

}
