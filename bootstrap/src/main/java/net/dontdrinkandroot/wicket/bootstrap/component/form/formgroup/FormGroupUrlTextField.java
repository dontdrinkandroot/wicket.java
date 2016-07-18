package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.markup.html.form.UrlTextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupUrlTextField;


public class FormGroupUrlTextField extends FormGroupInputGroup<String, UrlTextField, InputGroupUrlTextField>
{

	public FormGroupUrlTextField(String id, IModel<String> labelModel, IModel<String> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroup<String, UrlTextField> createInputGroup(String id)
	{
		return new InputGroupUrlTextField(id, this.getModel());
	}
}
