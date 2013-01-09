package net.dontdrinkandroot.wicket.headeritem.jquery;

import net.dontdrinkandroot.wicket.javascript.jquery.ThickboxResourceReference;

import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;


public class ThickboxHeaderItem extends JavaScriptReferenceHeaderItem {

	public ThickboxHeaderItem() {

		super(new ThickboxResourceReference(), null, "jquery.thickbox.js", false, null, null);
	}

}
