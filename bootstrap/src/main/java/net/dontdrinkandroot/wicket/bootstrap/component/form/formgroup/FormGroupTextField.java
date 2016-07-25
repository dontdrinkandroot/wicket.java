package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupTextField;


public class FormGroupTextField<T> extends FormGroupInputGroup<T, T, TextField<T>, InputGroupTextField<T>>
{

	public FormGroupTextField(String id, IModel<String> labelModel, IModel<T> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroup<T, T, TextField<T>> createInputGroup(String id)
	{
		return new InputGroupTextField<T>(id, this.getModel()) {

			@Override
			protected Component createInputGroupAddonBefore(String id)
			{
				return FormGroupTextField.this.createInputGroupAddonBefore(id);
			}

			@Override
			protected Component createInputGroupAddonAfter(String id)
			{
				return FormGroupTextField.this.createInputGroupAddonAfter(id);
			}
		};
	}
}
