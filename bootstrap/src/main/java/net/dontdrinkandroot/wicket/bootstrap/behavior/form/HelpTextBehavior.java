package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;


public class HelpTextBehavior extends Behavior
{

	private IModel<String> helpTextModel;


	public HelpTextBehavior(IModel<String> helpTextModel)
	{
		super();
		this.helpTextModel = helpTextModel;
	}

	@Override
	public void onConfigure(Component component)
	{
		super.onConfigure(component);
		component.info(this.helpTextModel.getObject());
	}

}
