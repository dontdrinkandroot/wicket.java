package net.dontdrinkandroot.wicket.example.page.form;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupTextFieldString;


public class InputGroupPage extends FormPage
{

	public InputGroupPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		InputGroupTextFieldString labels = new InputGroupTextFieldString("labels", Model.of("")) {

			@Override
			protected Component createInputGroupAddonBefore(String id)
			{
				return new InputGroupLabel(id, Model.of("Before"));
			}

			@Override
			protected Component createInputGroupAddonAfter(String id)
			{
				return new InputGroupLabel(id, Model.of("After"));
			}

		};
		this.add(labels);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Input Groups");
	}
}
