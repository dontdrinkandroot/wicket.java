package net.dontdrinkandroot.wicket.headeritem;

import org.apache.wicket.markup.head.CssUrlReferenceHeaderItem;


public class ExternalJQueryUiCssHeaderItem extends CssUrlReferenceHeaderItem {

	public ExternalJQueryUiCssHeaderItem(boolean defer) {

		super("http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css", "screen", null);
	}

}
