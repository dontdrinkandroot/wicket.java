package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.markup.html.WebMarkupContainer;


public class DividerItem extends WebMarkupContainer {

	public DividerItem(String id) {

		super(id);
		this.add(new CssClassAppender(BootstrapCssClass.DIVIDER));
	}

}
