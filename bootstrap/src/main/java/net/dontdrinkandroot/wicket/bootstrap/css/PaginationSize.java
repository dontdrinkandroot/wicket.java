package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum PaginationSize implements CssClass {

	MINI("pagination-mini"),
	SMALL("pagination-small"),
	LARGE("pagination-large");

	private final String classString;


	private PaginationSize(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}
}
