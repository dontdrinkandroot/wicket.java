package net.dontdrinkandroot.wicket.bootstrap.headeritem;

import net.dontdrinkandroot.wicket.bootstrap.javascript.BootstrapJsResourceReference;

import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;


public class BootstrapJsHeaderItem extends JavaScriptReferenceHeaderItem {

	public BootstrapJsHeaderItem(boolean defer) {

		super(new BootstrapJsResourceReference(), null, "bootstrap.js", defer, null, null);
	}

}
