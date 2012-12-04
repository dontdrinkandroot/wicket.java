package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum SpanClass implements CssClass {

	SPAN_1("span1"),
	SPAN_2("span2"),
	SPAN_3("span3"),
	SPAN_4("span4"),
	SPAN_5("span5"),
	SPAN_6("span6"),
	SPAN_7("span7"),
	SPAN_8("span8"),
	SPAN_9("span9"),
	SPAN_10("span10"),
	SPAN_11("span11"),
	SPAN_12("span12");

	private String classString;


	private SpanClass(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return this.classString;
	}

}
