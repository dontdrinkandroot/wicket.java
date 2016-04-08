package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;


abstract public class AbstractFormGroupTextField<T, F extends TextField<T>> extends AbstractFormGroup<T, F>
{

	public AbstractFormGroupTextField(String id, IModel<T> model, String label)
	{
		super(id, model, label);
	}

	public AbstractFormGroupTextField(String id, IModel<T> model, IModel<String> labelModel)
	{
		super(id, model, labelModel);
	}

	public AbstractFormGroupTextField(String id, IModel<T> model, IModel<String> labelModel, Class<T> type)
	{
		super(id, model, labelModel, type);
	}

}
