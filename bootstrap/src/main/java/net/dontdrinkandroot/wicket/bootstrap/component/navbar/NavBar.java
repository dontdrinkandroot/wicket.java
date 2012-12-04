package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.markup.html.panel.GenericPanel;


public class NavBar extends GenericPanel<Void> {

	public NavBar(String id) {

		super(id);
		this.add(new CssClassAppender(BootstrapCssClass.NAVBAR));
	}

}
