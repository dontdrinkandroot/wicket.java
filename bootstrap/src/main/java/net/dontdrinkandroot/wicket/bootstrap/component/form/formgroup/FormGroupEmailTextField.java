package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupEmailTextField;


public class FormGroupEmailTextField extends FormGroupInputGroup<String, EmailTextField, InputGroupEmailTextField>
{

	public FormGroupEmailTextField(String id, IModel<String> labelModel, IModel<String> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroup<String, EmailTextField> createInputGroup(String id)
	{
		return new InputGroupEmailTextField(id, this.getModel()) {

			@Override
			protected Component createInputGroupAddonBefore(String id)
			{
				return FormGroupEmailTextField.this.createInputGroupAddonBefore(id);
			}

			@Override
			protected Component createInputGroupAddonAfter(String id)
			{
				return FormGroupEmailTextField.this.createInputGroupAddonAfter(id);
			}
		};
	}
}
