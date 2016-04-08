package net.dontdrinkandroot.wicket.bootstrap.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;


public class OnBlurValidationBehavior extends AjaxFormComponentUpdatingBehavior
{

	private Component targetComponent;


	public OnBlurValidationBehavior(Component targetComponent)
	{
		super("blur");
		this.targetComponent = targetComponent;
	}

	@Override
	protected void onUpdate(AjaxRequestTarget target)
	{
		target.add(this.targetComponent);
	}

	@Override
	protected void onError(AjaxRequestTarget target, RuntimeException e)
	{
		super.onError(target, e);
		target.add(this.targetComponent);
	}

}
