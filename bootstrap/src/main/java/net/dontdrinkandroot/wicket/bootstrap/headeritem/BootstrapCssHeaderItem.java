package net.dontdrinkandroot.wicket.bootstrap.headeritem;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssResourceReference;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;


public class BootstrapCssHeaderItem extends CssReferenceHeaderItem {

	public BootstrapCssHeaderItem() {

		super(new BootstrapCssResourceReference(), null, "screen", null);
	}

}
