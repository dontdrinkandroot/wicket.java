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
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupCheckBox;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupPasswordTextField;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupStatic;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextArea;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextField;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import net.dontdrinkandroot.wicket.example.page.DecoratorPage;
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel;


public abstract class FormPage extends DecoratorPage<Void>
{

	public FormPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageTitlePrefixModel()
	{
		return new ConcatenatingStringModel(super.createPageTitlePrefixModel(), " - ", Model.of("Forms"));
	}

	protected void populateFormGroups(Form<Void> form, RepeatingView formGroupView)
	{
		FormGroupStatic formGroupStatic = new FormGroupStatic(
				formGroupView.newChildId(),
				Model.of(FormGroupStatic.class.getSimpleName()),
				Model.of("A static label"));
		formGroupView.add(formGroupStatic);

		FormGroupTextField<String> formGroupTextField = new FormGroupTextField<String>(
				formGroupView.newChildId(),
				Model.of(FormGroupTextField.class.getSimpleName()),
				Model.of(""));
		formGroupTextField.getFormComponent().setRequired(true);
		formGroupTextField.addAjaxValidation("input", new ThrottlingSettings(Duration.milliseconds(250)));
		formGroupTextField.setHelpTextModel(Model.of("A help text"));
		formGroupView.add(formGroupTextField);

		FormGroupPasswordTextField formGroupPasswordTextField = new FormGroupPasswordTextField(
				formGroupView.newChildId(),
				Model.of(FormGroupPasswordTextField.class.getSimpleName()),
				Model.of(""));
		formGroupView.add(formGroupPasswordTextField);

		FormGroupTextArea<String> formGroupTextArea = new FormGroupTextArea<String>(
				formGroupView.newChildId(),
				Model.of(FormGroupTextArea.class.getSimpleName()),
				Model.of(""));
		formGroupTextArea.setRequired(true);
		formGroupView.add(formGroupTextArea);

		FormGroupCheckBox formGroupCheckBox = new FormGroupCheckBox(
				formGroupView.newChildId(),
				Model.of(FormGroupCheckBox.class.getSimpleName()),
				new Model<Boolean>());
		formGroupView.add(formGroupCheckBox);

		FormGroupActions<Void> formGroupActions = new FormGroupActions<Void>(formGroupView.newChildId()) {

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
		};
		formGroupView.add(formGroupActions);
	}
}
