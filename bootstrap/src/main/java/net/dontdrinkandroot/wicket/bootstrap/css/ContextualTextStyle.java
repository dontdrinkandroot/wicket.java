package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum ContextualTextStyle implements CssClass
{

	MUTED("text-muted"),
	PRIMARY("text-primary"),
	SUCCESS("text-success"),
	INFO("text-info"),
	WARNING("text-warning"),
	DANGER("text-danger");

	private String classString;


	private ContextualTextStyle(String classString)
	{
		this.classString = classString;
	}

	@Override
	public String getClassString()
	{
		return this.classString;
	}
}
