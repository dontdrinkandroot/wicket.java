package net.dontdrinkandroot.wicket.example.page.form;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupActions;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupCheckBox;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupEmailTextField;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupPasswordTextField;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupRadioChoice;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupSelect;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupStatic;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextArea;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextFieldString;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupUrlTextField;
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
		List<String> choices = Arrays.asList(new String[] { "Apple", "Banana", "Pear" });

		FormGroupStatic formGroupStatic = new FormGroupStatic(
				formGroupView.newChildId(),
				Model.of(FormGroupStatic.class.getSimpleName()),
				Model.of("A static label"));
		formGroupView.add(formGroupStatic);

		FormGroupTextFieldString formGroupTextField = new FormGroupTextFieldString(
				formGroupView.newChildId(),
				Model.of(FormGroupTextFieldString.class.getSimpleName()),
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

		FormGroupEmailTextField formGroupEmailTextField = new FormGroupEmailTextField(
				formGroupView.newChildId(),
				Model.of(FormGroupEmailTextField.class.getSimpleName()),
				Model.of(""));
		formGroupView.add(formGroupEmailTextField);

		FormGroupUrlTextField formGroupUrlTextField = new FormGroupUrlTextField(
				formGroupView.newChildId(),
				Model.of(FormGroupUrlTextField.class.getSimpleName()),
				Model.of(""));
		formGroupView.add(formGroupUrlTextField);

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

		FormGroupRadioChoice<String> formGroupRadioChoice = new FormGroupRadioChoice<String>(
				formGroupView.newChildId(),
				Model.of(FormGroupRadioChoice.class.getSimpleName()),
				Model.of(""),
				choices);
		formGroupView.add(formGroupRadioChoice);

		FormGroupSelect<String> formGroupSelect = new FormGroupSelect<String>(
				formGroupView.newChildId(),
				Model.of(FormGroupSelect.class.getSimpleName()),
				Model.of(""),
				choices);
		formGroupSelect.setRequired(false);
		formGroupSelect.setNullValid(true);
		formGroupView.add(formGroupSelect);

		FormGroupActions<Void> formGroupActions = new FormGroupActions<Void>(formGroupView.newChildId()) {

			@Override
			protected void populateActions(RepeatingView actionView)
			{
				AjaxSubmitButton submitButton = new AjaxSubmitButton(actionView.newChildId()) {

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
