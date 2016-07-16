package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum TextTransformation implements CssClass
{

	LOWERCASE("text-lowercase"),
	UPPERCASE("text-uppercase"),
	CAPITALIZE("text-capitalize");

	private String classString;


	private TextTransformation(String classString)
	{
		this.classString = classString;
	}

	@Override
	public String getClassString()
	{
		return this.classString;
	}
}
