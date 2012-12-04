package net.dontdrinkandroot.wicket.bootstrap.component.nav;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.markup.html.WebMarkupContainer;


public class NavItemDivider extends WebMarkupContainer {

	public NavItemDivider(String id) {

		super(id);
		this.add(new CssClassAppender(BootstrapCssClass.DIVIDER));
	}

}
