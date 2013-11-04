package net.dontdrinkandroot.wicket.bootstrap.headeritem;

import java.util.Collections;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapThemeCssResourceReference;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;


public class BootstrapThemeCssHeaderItem extends CssReferenceHeaderItem {

	public BootstrapThemeCssHeaderItem() {

		super(new BootstrapThemeCssResourceReference(), null, "screen", null);
	}


	@Override
	public Iterable<? extends HeaderItem> getDependencies() {

		return Collections.singleton(new BootstrapCssHeaderItem());
	}

}
