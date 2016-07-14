package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;


abstract public class AbstractFormGroupTextField<T, F extends TextField<T>> extends FormGroupFormComponent<T, F>
{

	public AbstractFormGroupTextField(String id, IModel<String> labelModel, IModel<T> model)
	{
		super(id, labelModel, model);
	}

	public AbstractFormGroupTextField(String id, IModel<String> labelModel, IModel<T> model, Class<T> type)
	{
		super(id, labelModel, model, type);
	}

}
