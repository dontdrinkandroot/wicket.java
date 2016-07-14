package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import java.util.List;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.AutoCompleteTextField;


public abstract class FormGroupAutoComplete extends FormGroupFormComponent<String, TextField<String>>
{

	private AutoCompleteTextField autoCompleteTextField;


	public FormGroupAutoComplete(String id, IModel<String> labelModel, IModel<String> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected TextField<String> createFormComponent(String id)
	{
		this.autoCompleteTextField = new AutoCompleteTextField(id, this.getModel()) {

			@Override
			protected List<String> getChoices(String input)
			{
				return FormGroupAutoComplete.this.getChoices(input);
			}
		};
		return this.autoCompleteTextField.getTextField();
	}

	protected abstract List<String> getChoices(String input);

}
