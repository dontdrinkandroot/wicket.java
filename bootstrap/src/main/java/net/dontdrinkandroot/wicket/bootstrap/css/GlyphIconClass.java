package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum GlyphIconClass implements CssClass {

	ASTERISK("glyphicon-asterisk"),
	PLUS("glyphicon-plus"),
	EURO("glyphicon-euro"),
	MINUS("glyphicon-minus"),
	CLOUD("glyphicon-cloud"),
	ENVELOPE("glyphicon-envelope"),
	PENCIL("glyphicon-pencil"),
	GLASS("glyphicon-glass"),
	USER("glyphicon-user");

	private final String classString;


	private GlyphIconClass(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return "glyphicon " + this.classString;
	}

}
