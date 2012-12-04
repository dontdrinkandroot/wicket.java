package net.dontdrinkandroot.wicket.css;

public enum CoreCssClass implements CssClass {

	DATE_PICKER("datepicker");

	private String msgKey;


	private CoreCssClass(String msgKey) {

		this.msgKey = msgKey;
	}


	@Override
	public String getClassString() {

		return this.msgKey;
	}

}
