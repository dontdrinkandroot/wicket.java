package net.dontdrinkandroot.wicket.example.page.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupActions;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextFieldString;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public class ValidationPage extends FormPage
{

	public ValidationPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Validations");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		Form<Void> form = new Form<Void>("form");
		this.add(form);

		RepeatingView formGroupView = new RepeatingView("formGroup");
		form.add(formGroupView);

		FormGroupTextFieldString requiredFormGroup =
				new FormGroupTextFieldString(formGroupView.newChildId(), Model.of("Required"), new Model<String>());
		requiredFormGroup.setRequired(true);
		formGroupView.add(requiredFormGroup);

		FormGroupTextFieldString ajaxValidationFormGroup = new FormGroupTextFieldString(
				formGroupView.newChildId(),
				Model.of("Ajax Validation"),
				new Model<String>("Type to see what's happening"));
		ajaxValidationFormGroup.setRequired(true);
		ajaxValidationFormGroup.getFormComponent().add(new IValidator<String>() {

			@Override
			public void validate(IValidatable<String> validatable)
			{
				if (!"your mother".equals(validatable.getValue())) {
					validatable.error(new ValidationError("I only accept 'your mother'"));
				}
			}
		});
		ajaxValidationFormGroup.addAjaxValidation("input", new ThrottlingSettings(Duration.milliseconds(250)));
		formGroupView.add(ajaxValidationFormGroup);

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
