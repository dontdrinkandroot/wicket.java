package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import java.util.List;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.form.AutoCompleteTextField;


public abstract class FormGroupAutoComplete extends AbstractFormGroup<String, TextField<String>>
{

	private AutoCompleteTextField autoCompleteTextField;


	public FormGroupAutoComplete(String id, IModel<String> model, IModel<String> labelModel)
	{
		super(id, model, labelModel);
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

	@Override
	protected void applyComponentAdd()
	{
		this.add(this.componentContainer);
		this.componentContainer.add(this.autoCompleteTextField);
		this.add(this.label);
		this.componentContainer.add(this.helpBlock);
	}

	protected abstract List<String> getChoices(String input);

}
