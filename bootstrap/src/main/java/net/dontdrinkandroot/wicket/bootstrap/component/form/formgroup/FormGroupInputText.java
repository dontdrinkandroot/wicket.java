package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupText;


public class FormGroupInputText
		extends FormGroupInputGroup<String, String, TextField<String>, InputGroupText>
{

	public FormGroupInputText(String id, IModel<String> labelModel, IModel<String> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroupText createInputGroup(String id)
	{
		return new InputGroupText(id, this.getModel()) {

			@Override
			protected Component createInputGroupAddonBefore(String id)
			{
				return FormGroupInputText.this.createInputGroupAddonBefore(id);
			}

			@Override
			protected Component createInputGroupAddonAfter(String id)
			{
				return FormGroupInputText.this.createInputGroupAddonAfter(id);
			}
		};
	}
}
