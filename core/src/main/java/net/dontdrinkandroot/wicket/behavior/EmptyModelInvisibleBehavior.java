package net.dontdrinkandroot.wicket.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;


public class EmptyModelInvisibleBehavior extends Behavior
{

	@Override
	public void onConfigure(Component component)
	{
		super.onConfigure(component);
		IModel<?> model = component.getDefaultModel();
		if ((null == model) || (null == model.getObject())) {
			component.setVisible(false);
		}
	}
}
