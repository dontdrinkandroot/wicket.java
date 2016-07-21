package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum ValidationState implements CssClass
{
	SUCCESS("has-success"),
	WARNING("has-warning"),
	ERROR("has-error");

	private String classString;


	private ValidationState(String classString)
	{

		this.classString = classString;
	}

	@Override
	public String getClassString()
	{

		return this.classString;
	}

}
