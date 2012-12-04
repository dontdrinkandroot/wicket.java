package net.dontdrinkandroot.wicket.bootstrap.css;

import java.util.Collections;

import net.dontdrinkandroot.wicket.bootstrap.javascript.BootstrapResourceReference;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;


public class BoostrapResponsiveCssResourceReference extends CssResourceReference {

	public BoostrapResponsiveCssResourceReference() {

		super(BoostrapResponsiveCssResourceReference.class, "bootstrap-responsive-2.2.1.min.css");
	}


	@Override
	public Iterable<? extends HeaderItem> getDependencies() {

		HeaderItem stylesheet = CssHeaderItem.forReference(new BootstrapResourceReference());
		return Collections.singleton(stylesheet);
	}

}
