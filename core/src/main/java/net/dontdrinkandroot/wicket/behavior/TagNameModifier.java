package net.dontdrinkandroot.wicket.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;


public class TagNameModifier extends Behavior
{

	private String tagName;


	public TagNameModifier(String tagName)
	{
		this.tagName = tagName;
	}

	@Override
	public void onComponentTag(Component component, ComponentTag tag)
	{
		tag.setName(this.tagName);
		super.onComponentTag(component, tag);
	}
}
