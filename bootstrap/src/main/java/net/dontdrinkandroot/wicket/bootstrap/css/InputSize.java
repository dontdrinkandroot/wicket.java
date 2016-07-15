package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum InputSize implements CssClass
{
	SMALL("input-sm"),
	LARGE("input-lg");

	private String classString;


	private InputSize(String classString)
	{

		this.classString = classString;
	}

	@Override
	public String getClassString()
	{

		return this.classString;
	}

}
