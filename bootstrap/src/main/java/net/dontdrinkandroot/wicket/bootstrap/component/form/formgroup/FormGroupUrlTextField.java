package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.UrlTextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupUrlTextField;


public class FormGroupUrlTextField extends FormGroupInputGroup<String, String, UrlTextField, InputGroupUrlTextField>
{

	public FormGroupUrlTextField(String id, IModel<String> labelModel, IModel<String> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected InputGroupUrlTextField createInputGroup(String id)
	{
		return new InputGroupUrlTextField(id, this.getModel()) {

			@Override
			protected Component createInputGroupAddonBefore(String id)
			{
				return FormGroupUrlTextField.this.createInputGroupAddonBefore(id);
			}

			@Override
			protected Component createInputGroupAddonAfter(String id)
			{
				return FormGroupUrlTextField.this.createInputGroupAddonAfter(id);
			}
		};
	}
}
