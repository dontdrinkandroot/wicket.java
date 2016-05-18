package net.dontdrinkandroot.wicket.css;

import java.io.Serializable;


public class SimpleCssClass implements CssClass, Serializable
{

	private String classString;


	public SimpleCssClass(String classString)
	{
		this.classString = classString;
	}

	@Override
	public String getClassString()
	{
		return this.classString;
	}

}
