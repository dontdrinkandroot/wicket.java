/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.example.page.form;

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupActions;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputEmail;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
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

        RepeatingView stateFormGroupView = new RepeatingView("stateFormGroup");
        this.add(stateFormGroupView);

        FormGroupInputText formGroupInputText;
        formGroupInputText = new FormGroupInputText(stateFormGroupView.newChildId(), Model.of("Success"), Model.of(""));
        formGroupInputText.getFormComponent().success("Success message");
        stateFormGroupView.add(formGroupInputText);

        formGroupInputText = new FormGroupInputText(stateFormGroupView.newChildId(), Model.of("Warning"), Model.of(""));
        formGroupInputText.getFormComponent().warn("Warn message");
        stateFormGroupView.add(formGroupInputText);

        formGroupInputText = new FormGroupInputText(stateFormGroupView.newChildId(), Model.of("Error"), Model.of(""));
        formGroupInputText.getFormComponent().error("Error message");
        stateFormGroupView.add(formGroupInputText);

        RepeatingView formGroupView = new RepeatingView("formGroup");
        form.add(formGroupView);

        FormGroupInputEmail validationFormGroup = new FormGroupInputEmail(
                formGroupView.newChildId(),
                Model.of("Validation (email)"),
                new Model<String>("")
        );
        validationFormGroup.setRequired(true);
        validationFormGroup.addAjaxValidation("input", new ThrottlingSettings(Duration.milliseconds(250)));
        formGroupView.add(validationFormGroup);

        FormGroupInputEmail ajaxValidationFormGroup = new FormGroupInputEmail(
                formGroupView.newChildId(),
                Model.of("Ajax Validation (email)"),
                new Model<String>("Type to see what's happening")
        );
        ajaxValidationFormGroup.setRequired(true);
        ajaxValidationFormGroup.addAjaxValidation("input", new ThrottlingSettings(Duration.milliseconds(250)));
        formGroupView.add(ajaxValidationFormGroup);

        FormGroupActions<Void> formGroupActions = new FormGroupActions<Void>(formGroupView.newChildId())
        {

            @Override
            protected void populateActions(RepeatingView actionView)
            {
                AjaxSubmitButton submitButton = new AjaxSubmitButton(actionView.newChildId())
                {
                    @Override
                    protected void onSubmit(AjaxRequestTarget target)
                    {
                        this.success("Your form is valid");
                        target.add(ValidationPage.this.getFeedbackPanel());
                        target.add(this.getForm());
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
