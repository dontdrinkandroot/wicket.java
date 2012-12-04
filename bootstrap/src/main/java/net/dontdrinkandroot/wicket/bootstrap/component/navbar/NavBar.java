package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.component.TypedPanel;


public class NavBar extends TypedPanel<Void> {

	public NavBar(String id) {

		super(id);
		this.add(new CssClassAppender(BootstrapCssClass.NAVBAR));
	}

}
