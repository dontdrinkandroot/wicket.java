package net.dontdrinkandroot.wicket.bootstrap.css;

import java.util.Collections;

import net.dontdrinkandroot.wicket.bootstrap.headeritem.BootstrapCssHeaderItem;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;


public class BootstrapResponsiveCssResourceReference extends CssResourceReference {

	public BootstrapResponsiveCssResourceReference() {

		super(BootstrapResponsiveCssResourceReference.class, "bootstrap-responsive-2.3.1.min.css");
	}


	@Override
	public Iterable<? extends HeaderItem> getDependencies() {

		return Collections.singleton(new BootstrapCssHeaderItem());
	}

}
