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
package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupActions
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputEmail
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.attributes.ThrottlingSettings
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters
import java.time.Duration

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class ValidationPage(parameters: PageParameters?) : FormPage(parameters)
{
    override fun createPageHeadingModel(): IModel<String>
    {
        return Model.of("Validations")
    }

    override fun onInitialize()
    {
        super.onInitialize()
        val form = Form<Void>("form")
        this.add(form)
        val stateFormGroupView = RepeatingView("stateFormGroup")
        this.add(stateFormGroupView)
        var formGroupInputText: FormGroupInputText
        formGroupInputText = FormGroupInputText(stateFormGroupView.newChildId(), Model.of("Success"), Model.of(""))
        formGroupInputText.formComponent.success("Success message")
        stateFormGroupView.add(formGroupInputText)
        formGroupInputText = FormGroupInputText(stateFormGroupView.newChildId(), Model.of("Warning"), Model.of(""))
        formGroupInputText.formComponent.warn("Warn message")
        stateFormGroupView.add(formGroupInputText)
        formGroupInputText = FormGroupInputText(stateFormGroupView.newChildId(), Model.of("Error"), Model.of(""))
        formGroupInputText.formComponent.error("Error message")
        stateFormGroupView.add(formGroupInputText)
        val formGroupView = RepeatingView("formGroup")
        form.add(formGroupView)
        val validationFormGroup = FormGroupInputEmail(
            formGroupView.newChildId(),
            Model.of("Validation (email)"),
            Model("")
        )
        validationFormGroup.setRequired(true)
        validationFormGroup.addAjaxValidation("input", ThrottlingSettings(Duration.ofMillis(250)))
        formGroupView.add(validationFormGroup)
        val ajaxValidationFormGroup = FormGroupInputEmail(
            formGroupView.newChildId(),
            Model.of("Ajax Validation (email)"),
            Model("Type to see what's happening")
        )
        ajaxValidationFormGroup.setRequired(true)
        ajaxValidationFormGroup.addAjaxValidation("input", ThrottlingSettings(Duration.ofMillis(250)))
        formGroupView.add(ajaxValidationFormGroup)
        val formGroupActions: FormGroupActions<Void> = object : FormGroupActions<Void>(formGroupView.newChildId())
        {
            override fun populateActions(actionView: RepeatingView)
            {
                val submitButton: AjaxSubmitButton = object : AjaxSubmitButton(actionView.newChildId())
                {
                    override fun onSubmit(target: AjaxRequestTarget)
                    {
                        this.success("Your form is valid")
                        target.add(feedbackPanel)
                        target.add(this.form)
                    }
                }
                submitButton.body = Model.of("Submit")
                submitButton.buttonStyle = ButtonStyle.PRIMARY
                actionView.add(submitButton)
            }
        }
        formGroupView.add(formGroupActions)
    }
}