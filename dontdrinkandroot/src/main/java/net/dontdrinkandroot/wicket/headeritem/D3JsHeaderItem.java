package net.dontdrinkandroot.wicket.headeritem;

import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;


public class D3JsHeaderItem extends JavaScriptUrlReferenceHeaderItem {

	public D3JsHeaderItem() {

		super("http://design.dontdrinkandroot.net/js/d3/d3.v3.min.js", "d3.js", false, null, null);
	}

}
