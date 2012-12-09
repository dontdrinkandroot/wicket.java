package net.dontdrinkandroot.wicket.bootstrap.headeritem;

import java.util.Collections;

import net.dontdrinkandroot.wicket.bootstrap.javascript.BootstrapJsResourceReference;

import org.apache.wicket.ajax.WicketEventJQueryResourceReference;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;


public class BootstrapJsHeaderItem extends JavaScriptReferenceHeaderItem {

	public BootstrapJsHeaderItem(boolean defer) {

		super(new BootstrapJsResourceReference(), null, "bootstrapjs", defer, null, null);
	}


	@Override
	public Iterable<? extends HeaderItem> getDependencies() {

		HeaderItem jQuery = JavaScriptHeaderItem.forReference(WicketEventJQueryResourceReference.get());

		return Collections.singletonList(jQuery);
	}
}
