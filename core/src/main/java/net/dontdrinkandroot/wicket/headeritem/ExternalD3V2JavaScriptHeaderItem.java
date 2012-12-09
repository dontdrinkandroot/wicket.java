package net.dontdrinkandroot.wicket.headeritem;

import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;


public class ExternalD3V2JavaScriptHeaderItem extends JavaScriptUrlReferenceHeaderItem {

	public ExternalD3V2JavaScriptHeaderItem(boolean defer) {

		super("http://d3js.org/d3.v2.min.js", "d3", defer, null, null);
	}

}
