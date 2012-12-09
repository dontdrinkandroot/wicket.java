package net.dontdrinkandroot.wicket.bootstrap.headeritem;

import java.util.Collections;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssResourceReference;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;


public class BootstrapResponsiveCssHeaderItem extends CssReferenceHeaderItem {

	public BootstrapResponsiveCssHeaderItem() {

		super(new BootstrapCssResourceReference(), null, "screen", null);
	}


	@Override
	public Iterable<? extends HeaderItem> getDependencies() {

		return Collections.singleton(new BootstrapCssHeaderItem());
	}

}
