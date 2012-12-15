package net.dontdrinkandroot.wicket.bootstrap.javascript;

import java.util.Collections;

import org.apache.wicket.ajax.WicketEventJQueryResourceReference;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;


public class BootstrapJsResourceReference extends JavaScriptResourceReference {

	public BootstrapJsResourceReference() {

		super(BootstrapJsResourceReference.class, "bootstrap-2.2.2.min.js");
	}


	@Override
	public Iterable<? extends HeaderItem> getDependencies() {

		HeaderItem jQuery = JavaScriptHeaderItem.forReference(WicketEventJQueryResourceReference.get());

		return Collections.singletonList(jQuery);
	}
}
