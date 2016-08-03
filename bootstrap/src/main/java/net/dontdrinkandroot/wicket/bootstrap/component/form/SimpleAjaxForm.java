package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.model.IModel;


public class SimpleAjaxForm<T> extends SimpleForm<T>
{

	public SimpleAjaxForm(String id)
	{
		super(id);
		this.createSubmitBehavior();
	}

	public SimpleAjaxForm(String id, IModel<T> model)
	{
		super(id, model);
		this.createSubmitBehavior();
	}

	protected void createSubmitBehavior()
	{
		this.add(new AjaxFormSubmitBehavior(this, "submit") {

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
			{
				super.updateAjaxAttributes(attributes);
				attributes.setPreventDefault(true);
			}

			@Override
			protected void onError(AjaxRequestTarget target)
			{
				super.onError(target);
				SimpleAjaxForm.this.onError(target);
			}

			@Override
			protected void onSubmit(AjaxRequestTarget target)
			{
				super.onSubmit(target);
				SimpleAjaxForm.this.onSubmit(target);
			}

			@Override
			protected void onAfterSubmit(AjaxRequestTarget target)
			{
				super.onAfterSubmit(target);
				SimpleAjaxForm.this.onAfterSubmit(target);
			}
		});
	}

	protected void onAfterSubmit(AjaxRequestTarget target)
	{
		/* Hook */
	}

	protected void onSubmit(AjaxRequestTarget target)
	{
		/* Hook */
	}

	protected void onError(AjaxRequestTarget target)
	{
		target.add(this);
	}

	@Override
	protected final void onError()
	{
		if (this.getRequestCycle().find(AjaxRequestTarget.class) == null) {
			this.onError(null);
		}
	}

	@Override
	protected final void onSubmit()
	{
		if (this.getRequestCycle().find(AjaxRequestTarget.class) == null) {
			this.onSubmit(null);
			this.onAfterSubmit(null);
		}
	}
}
