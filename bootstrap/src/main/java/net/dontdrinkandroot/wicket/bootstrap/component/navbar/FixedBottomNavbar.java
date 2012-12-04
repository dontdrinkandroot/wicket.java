package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public class FixedBottomNavbar extends NavBar {

	public FixedBottomNavbar(String id) {

		super(id);
		this.add(new CssClassAppender(BootstrapCssClass.NAVBAR_FIXED_BOTTOM));
	}

}
