package net.dontdrinkandroot.wicket.bootstrap.component.form;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public abstract class AutoCompleteTextField extends GenericPanel<String>
{

	private TextField<String> textField;


	public AutoCompleteTextField(String id, IModel<String> model)
	{
		super(id, model);
		this.textField = new TextField<String>("input", this.getModel());
		this.textField.setOutputMarkupId(true);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.setOutputMarkupId(true);
		this.add(new CssClassAppender(BootstrapCssClass.DROPDOWN));
		this.add(new CssClassAppender("autocomplete"));

		final WebMarkupContainer dropDownMenu = new WebMarkupContainer("dropDownMenu");
		dropDownMenu.setOutputMarkupId(true);
		this.add(dropDownMenu);

		this.add(this.textField);

		this.textField.add(new AjaxFormComponentUpdatingBehavior("input") {

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
			{
				super.updateAjaxAttributes(attributes);
				attributes.setThrottlingSettings(new ThrottlingSettings(Duration.milliseconds(250)));
			}

			@Override
			protected void onUpdate(AjaxRequestTarget target)
			{
				target.add(dropDownMenu);
			}
		});

		ListView<String> suggestionView =
				new ListView<String>("suggestionItem", new AbstractReadOnlyModel<List<String>>() {

					@Override
					public List<String> getObject()
					{
						return AutoCompleteTextField.this.getChoices(
								AutoCompleteTextField.this.textField.getModelObject());
					}
				}) {

					@Override
					protected void populateItem(ListItem<String> item)
					{
						AjaxLink<String> link = new AjaxLink<String>("link", item.getModel()) {

							@Override
							public void onClick(AjaxRequestTarget target)
							{
								AutoCompleteTextField.this.textField.getModel().setObject(this.getModelObject());
								target.add(AutoCompleteTextField.this.textField);
								target.add(dropDownMenu);
							}
						};
						link.setBody(link.getModel());
						item.add(link);
					}
				};
		dropDownMenu.add(suggestionView);
	}

	public TextField<String> getTextField()
	{
		return this.textField;
	}

	protected abstract List<String> getChoices(String input);
}
