package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum TextAlignment implements CssClass
{

	LEFT("text-left"),
	CENTER("text-center"),
	RIGHT("text-right"),
	JUSTIFY("text-justify"),
	NOWRAP("text-nowrap");

	private String classString;


	private TextAlignment(String classString)
	{
		this.classString = classString;
	}

	@Override
	public String getClassString()
	{
		return this.classString;
	}
}
