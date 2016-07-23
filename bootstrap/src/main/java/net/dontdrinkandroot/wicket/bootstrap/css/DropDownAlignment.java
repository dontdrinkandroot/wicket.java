package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum DropDownAlignment implements CssClass
{
	LEFT("dropdown-menu-left"),
	RIGHT("dropdown-menu-right");

	private String classString;


	private DropDownAlignment(String classString)
	{
		this.classString = classString;
	}

	@Override
	public String getClassString()
	{
		return this.classString;
	}
}
