package net.dontdrinkandroot.wicket.example.page.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupActions;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupPasswordTextField;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupStatic;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextArea;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextField;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import net.dontdrinkandroot.wicket.example.page.DecoratorPage;


public abstract class FormPage extends DecoratorPage<Void>
{

	public FormPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageTitlePrefixModel()
	{
		return Model.of("Forms");
	}

	protected void populateFormGroups(Form<Void> form, RepeatingView formGroupView)
	{
		formGroupView.add(
				new FormGroupStatic(
						formGroupView.newChildId(),
						Model.of(FormGroupStatic.class.getSimpleName()),
						Model.of("A static label")));
		FormGroupTextField<String> formGroupTextField = new FormGroupTextField<String>(
				formGroupView.newChildId(),
				Model.of(FormGroupTextField.class.getSimpleName()),
				Model.of(""));
		formGroupTextField.getFormComponent().setRequired(true);
		formGroupTextField.addOnlineValidation("input", new ThrottlingSettings(Duration.milliseconds(250)));
		formGroupTextField.setHelpTextModel(Model.of("A help text"));
		formGroupView.add(formGroupTextField);
		formGroupView.add(
				new FormGroupPasswordTextField(
						formGroupView.newChildId(),
						Model.of(FormGroupPasswordTextField.class.getSimpleName()),
						Model.of("")));
		FormGroupTextArea<String> formGroupTextArea = new FormGroupTextArea<String>(
				formGroupView.newChildId(),
				Model.of(FormGroupTextArea.class.getSimpleName()),
				Model.of(""));
		formGroupTextArea.setRequired(true);
		formGroupView.add(formGroupTextArea);
		formGroupView.add(new FormGroupActions<Void>(formGroupView.newChildId()) {

			@Override
			protected void populateActions(RepeatingView actionView)
			{
				AjaxSubmitButtonLink submitButton = new AjaxSubmitButtonLink(actionView.newChildId()) {

					@Override
					protected void onError(AjaxRequestTarget target, Form<?> form)
					{
						super.onError(target, form);
						target.add(form);
					}
				};
				submitButton.setBody(Model.of("Submit"));
				submitButton.setButtonStyle(ButtonStyle.PRIMARY);
				actionView.add(submitButton);
			}
		});
	}
}
