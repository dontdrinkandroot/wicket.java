package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupTextField;


/**
 * @deprecated Use the type specific implementations.
 */
@Deprecated
public class FormGroupTextField<T> extends FormGroupInput<T, TextField<T>, InputGroupTextField<T>>
{

	public FormGroupTextField(String id, IModel<String> labelModel, IModel<T> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroup<T, TextField<T>> createInputGroup(String id)
	{
		return new InputGroupTextField<T>(id, this.getModel());
	}
}
