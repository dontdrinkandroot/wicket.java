package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;


public class ScreenReaderOnlyBehavior extends Behavior
{

	private IModel<Boolean> screenReaderOnlyModel;


	public ScreenReaderOnlyBehavior(IModel<Boolean> screenReaderOnlyModel)
	{
		this.screenReaderOnlyModel = screenReaderOnlyModel;
	}

	@Override
	public void bind(Component component)
	{
		super.bind(component);
	}

}
