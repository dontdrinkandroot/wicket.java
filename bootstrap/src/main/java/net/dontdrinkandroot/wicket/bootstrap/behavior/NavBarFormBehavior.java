package net.dontdrinkandroot.wicket.bootstrap.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public class NavBarFormBehavior extends Behavior
{

	@Override
	public void bind(Component component)
	{
		super.bind(component);
		component.add(new CssClassAppender(BootstrapCssClass.NAVBAR_FORM));
	}

}
