package net.dontdrinkandroot.wicket.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;


public class InputTypeModifier extends Behavior
{

	private InputType inputType;


	public InputTypeModifier(InputType inputType)
	{
		this.inputType = inputType;
	}

	@Override
	public void onComponentTag(Component component, ComponentTag tag)
	{
		tag.put("type", this.inputType.toString().toLowerCase());
		super.onComponentTag(component, tag);
	}


	public enum InputType
	{
		EMAIL,
		NUMBER,
		PASSWORD,
		TEXT,
		URL;
	}
}
