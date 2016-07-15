package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum FormGroupSize implements CssClass
{
	SMALL("form-group-sm"),
	LARGE("form-group-lg");

	private String classString;


	private FormGroupSize(String classString)
	{

		this.classString = classString;
	}

	@Override
	public String getClassString()
	{

		return this.classString;
	}

}
