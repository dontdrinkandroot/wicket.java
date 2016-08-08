package net.dontdrinkandroot.wicket.bootstrap.behavior;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


/**
 * Adds the required attributes for a DropDown Toggle.
 */
public class DropDownToggleBehavior extends Behavior
{

	@Override
	public void bind(Component component)
	{
		super.bind(component);

		component.add(new CssClassAppender(BootstrapCssClass.DROPDOWN_TOGGLE));
		component.add(new AttributeModifier("data-toggle", "dropdown"));
		component.add(new AttributeModifier("aria-haspopup", "true"));
		component.add(new AttributeModifier("aria-expanded", "false"));
	}
}
