package net.dontdrinkandroot.wicket.bootstrap.javascript;

import java.util.Collections;

import org.apache.wicket.ajax.WicketEventJQueryResourceReference;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;


public class BootstrapResourceReference extends JavaScriptResourceReference {

	public BootstrapResourceReference() {

		super(BootstrapResourceReference.class, "bootstrap-2.2.1.min.js");
	}


	@Override
	public Iterable<? extends HeaderItem> getDependencies() {

		HeaderItem jQuery = JavaScriptHeaderItem.forReference(WicketEventJQueryResourceReference.get());

		return Collections.singletonList(jQuery);
	}
}
