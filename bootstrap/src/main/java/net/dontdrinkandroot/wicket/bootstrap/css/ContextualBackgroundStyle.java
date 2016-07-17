package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum ContextualBackgroundStyle implements CssClass
{

	PRIMARY("bg-primary"),
	SUCCESS("bg-success"),
	INFO("bg-info"),
	WARNING("bg-warning"),
	DANGER("bg-danger");

	private String classString;


	private ContextualBackgroundStyle(String classString)
	{
		this.classString = classString;
	}

	@Override
	public String getClassString()
	{
		return this.classString;
	}
}
