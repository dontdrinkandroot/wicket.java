package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum PanelStyle implements CssClass {

	DEFAULT("panel-default"),
	PRIMARY("panel-primary"),
	SUCCESS("panel-success"),
	INFO("panel-info"),
	WARNING("panel-warning"),
	DANGER("panel-danger");

	private String classString;


	private PanelStyle(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}

}
