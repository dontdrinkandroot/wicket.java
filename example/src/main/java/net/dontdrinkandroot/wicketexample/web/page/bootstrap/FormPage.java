package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.component.button.DisablingSubmitButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.component.form.TextFieldControlGroup;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.EmailAddressValidator;


public class FormPage extends AbstractBootstrapPage<Void> {

	public FormPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>("Form Demo");
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		Form<Void> validationForm = new Form<Void>("validationForm");
		validationForm.setOutputMarkupId(true);
		this.add(validationForm);

		final TextFieldControlGroup<String> eMailField =
				new TextFieldControlGroup<String>("eMailField", new Model<String>(), new Model<String>("eMail"));
		eMailField.getFormComponent().add(EmailAddressValidator.getInstance());
		eMailField.getFormComponent().setRequired(true);
		validationForm.add(eMailField);

		final TextFieldControlGroup<String> requiredField =
				new TextFieldControlGroup<String>("requiredField", new Model<String>(), new Model<String>("required"));
		requiredField.getFormComponent().setRequired(true);
		validationForm.add(requiredField);

		DisablingSubmitButtonLink<Void> submitLink =
				new DisablingSubmitButtonLink<Void>("submitLink", null, new Model<String>("Submit")) {

					@Override
					protected void onSubmit(AjaxRequestTarget target, Form<?> form) {

						try {
							Thread.sleep(1000L);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						this.success(String.format(
								"Form validated successfully with eMail: %s and required: %s",
								eMailField.getModelObject(),
								requiredField.getModelObject()));
						target.add(FormPage.this.getFeedbackPanel());
						eMailField.setModelObject(null);
						requiredField.setModelObject(null);
						target.add(form);
					}


					@Override
					protected void onError(AjaxRequestTarget target, Form<?> form) {

						try {
							Thread.sleep(1000L);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						target.add(form);
					}
				};
		validationForm.add(submitLink);
	}
}
