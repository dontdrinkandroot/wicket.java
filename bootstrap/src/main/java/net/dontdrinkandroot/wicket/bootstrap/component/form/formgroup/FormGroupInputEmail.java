package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupEmail;


public class FormGroupInputEmail
		extends FormGroupInputGroup<String, String, EmailTextField, InputGroupEmail>
{

	public FormGroupInputEmail(String id, IModel<String> labelModel, IModel<String> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroupEmail createInputGroup(String id)
	{
		return new InputGroupEmail(id, this.getModel()) {

			@Override
			protected Component createInputGroupAddonBefore(String id)
			{
				return FormGroupInputEmail.this.createInputGroupAddonBefore(id);
			}

			@Override
			protected Component createInputGroupAddonAfter(String id)
			{
				return FormGroupInputEmail.this.createInputGroupAddonAfter(id);
			}
		};
	}
}
