package net.dontdrinkandroot.wicket.headeritem;

import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;


public class D3JavaScriptHeaderItem extends JavaScriptUrlReferenceHeaderItem {

	public D3JavaScriptHeaderItem(boolean defer) {

		super("http://d3js.org/d3.v2.min.js", "d3", defer, null, null);
	}

}
