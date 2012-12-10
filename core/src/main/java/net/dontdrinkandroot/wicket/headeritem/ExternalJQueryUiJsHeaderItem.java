package net.dontdrinkandroot.wicket.headeritem;

import java.util.Collections;

import org.apache.wicket.ajax.WicketEventJQueryResourceReference;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;


public class ExternalJQueryUiJsHeaderItem extends JavaScriptUrlReferenceHeaderItem {

	public ExternalJQueryUiJsHeaderItem(boolean defer) {

		super("http://code.jquery.com/ui/1.9.2/jquery-ui.js", "jqueryui.base", defer, null, null);
	}


	@Override
	public Iterable<? extends HeaderItem> getDependencies() {

		HeaderItem jQuery = JavaScriptHeaderItem.forReference(WicketEventJQueryResourceReference.get());

		return Collections.singletonList(jQuery);
	}

}
