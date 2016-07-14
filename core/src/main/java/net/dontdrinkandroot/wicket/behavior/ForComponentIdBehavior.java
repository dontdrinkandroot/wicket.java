package net.dontdrinkandroot.wicket.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;


/**
 * Adds a "for" attribute that will reference the id of the given targetComponent. Useful for Form Component Labels.
 */
public class ForComponentIdBehavior extends Behavior
{

	private Component targetComponent;


	public ForComponentIdBehavior(Component targetComponent)
	{
		this.targetComponent = targetComponent;
	}

	@Override
	public void onComponentTag(Component component, ComponentTag tag)
	{
		super.onComponentTag(component, tag);
		tag.put("for", this.targetComponent.getMarkupId());
	}

}
