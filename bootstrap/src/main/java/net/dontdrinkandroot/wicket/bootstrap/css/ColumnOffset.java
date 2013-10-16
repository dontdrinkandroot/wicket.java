package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum ColumnOffset implements CssClass {

	XS_1("col-xs-offset-1"),
	XS_2("col-xs-offset-2"),
	XS_3("col-xs-offset-3"),
	XS_4("col-xs-offset-4"),
	XS_5("col-xs-offset-5"),
	XS_6("col-xs-offset-6"),
	XS_7("col-xs-offset-7"),
	XS_8("col-xs-offset-8"),
	XS_9("col-xs-offset-9"),
	XS_10("col-xs-offset-10"),
	XS_11("col-xs-offset-11"),
	XS_12("col-xs-offset-12"),
	SM_1("col-sm-offset-1"),
	SM_2("col-sm-offset-2"),
	SM_3("col-sm-offset-3"),
	SM_4("col-sm-offset-4"),
	SM_5("col-sm-offset-5"),
	SM_6("col-sm-offset-6"),
	SM_7("col-sm-offset-7"),
	SM_8("col-sm-offset-8"),
	SM_9("col-sm-offset-9"),
	SM_10("col-sm-offset-10"),
	SM_11("col-sm-offset-11"),
	SM_12("col-sm-offset-12"),
	MD_1("col-md-offset-1"),
	MD_2("col-md-offset-2"),
	MD_3("col-md-offset-3"),
	MD_4("col-md-offset-4"),
	MD_5("col-md-offset-5"),
	MD_6("col-md-offset-6"),
	MD_7("col-md-offset-7"),
	MD_8("col-md-offset-8"),
	MD_9("col-md-offset-9"),
	MD_10("col-md-offset-10"),
	MD_11("col-md-offset-11"),
	MD_12("col-md-offset-12"),
	LG_1("col-lg-offset-1"),
	LG_2("col-lg-offset-2"),
	LG_3("col-lg-offset-3"),
	LG_4("col-lg-offset-4"),
	LG_5("col-lg-offset-5"),
	LG_6("col-lg-offset-6"),
	LG_7("col-lg-offset-7"),
	LG_8("col-lg-offset-8"),
	LG_9("col-lg-offset-9"),
	LG_10("col-lg-offset-10"),
	LG_11("col-lg-offset-11"),
	LG_12("col-lg-offset-12");

	private final String classString;


	private ColumnOffset(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}

}
