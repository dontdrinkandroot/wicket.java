package net.dontdrinkandroot.wicket.example.page.form;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupText;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupLabel;


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

		InputGroupText labels = new InputGroupText("labels", Model.of("")) {

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

		InputGroupText buttons = new InputGroupText("buttons", Model.of("")) {

			@Override
			protected Component createInputGroupAddonBefore(String id)
			{
				return new InputGroupButton<Void>(id) {

					@Override
					protected Component createLink(String id)
					{
						return new Label(id, Model.of("Before"));
					}
				};
			}

			@Override
			protected Component createInputGroupAddonAfter(String id)
			{
				return new InputGroupButton<Void>(id) {

					@Override
					protected Component createLink(String id)
					{
						return new Label(id, Model.of("After"));
					}
				};
			}
		};
		this.add(buttons);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Input Groups");
	}
}
