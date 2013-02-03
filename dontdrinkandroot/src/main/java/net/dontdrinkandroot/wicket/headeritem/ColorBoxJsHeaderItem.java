package net.dontdrinkandroot.wicket.headeritem;

import java.util.Collections;

import org.apache.wicket.ajax.WicketEventJQueryResourceReference;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;


public class ColorBoxJsHeaderItem extends JavaScriptUrlReferenceHeaderItem {

	public ColorBoxJsHeaderItem() {

		super(
				"http://design.dontdrinkandroot.net/js/colorbox/jquery.colorbox-1.3.32.min.js",
				"colorbox.js",
				false,
				null,
				null);
	}


	@Override
	public Iterable<? extends HeaderItem> getDependencies() {

		HeaderItem jQuery = JavaScriptHeaderItem.forReference(WicketEventJQueryResourceReference.get());

		return Collections.singletonList(jQuery);
	}
}
