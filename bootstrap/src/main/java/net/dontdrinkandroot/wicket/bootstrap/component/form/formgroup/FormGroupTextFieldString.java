package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupTextFieldString;


public class FormGroupTextFieldString extends FormGroupInput<String, TextField<String>, InputGroupTextFieldString>
{

	public FormGroupTextFieldString(String id, IModel<String> labelModel, IModel<String> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroupTextFieldString createInputGroup(String id)
	{
		return new InputGroupTextFieldString(id, this.getModel());
	}
}
