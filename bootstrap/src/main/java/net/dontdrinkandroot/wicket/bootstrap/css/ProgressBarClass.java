package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum ProgressBarClass implements CssClass {

	INFO("progress-info"),
	SUCCESS("progress-success"),
	WARNING("progress-warning"),
	DANGER("progress-danger"),

	INFO_STRIPED("progress-info progress-striped"),
	SUCCESS_STRIPED("progress-success progress-striped"),
	WARNING_STRIPED("progress-warning progress-striped"),
	DANGER_STRIPED("progress-danger progress-striped");

	private String classString;


	private ProgressBarClass(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}

}
