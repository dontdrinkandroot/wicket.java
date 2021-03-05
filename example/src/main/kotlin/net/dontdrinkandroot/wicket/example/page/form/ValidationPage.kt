package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupActions
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputEmail
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.css.Spacing
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class ValidationPage(parameters: PageParameters) : FormPage(parameters) {

    override fun createPageHeadingModel() = Model("Validations")

    override fun onInitialize() {
        super.onInitialize()

        val form = Form<Void>("form")
        this.add(form)

        val stateFormGroupView = RepeatingView("stateFormGroup")
        this.add(stateFormGroupView)

        val formGroupInputTextSuccess =
            FormGroupInputText(stateFormGroupView.newChildId(), Model.of(""), Model("Success"))
        formGroupInputTextSuccess.formComponent.success("Success message")
        formGroupInputTextSuccess.add(CssClassAppender(Spacing.MARGIN_BOTTOM_FULL))
        stateFormGroupView.add(formGroupInputTextSuccess)

        val formGroupInputTextWarn =
            FormGroupInputText(stateFormGroupView.newChildId(), Model.of(""), Model("Warning"))
        formGroupInputTextWarn.formComponent.warn("Warn message")
        formGroupInputTextWarn.add(CssClassAppender(Spacing.MARGIN_BOTTOM_FULL))
        stateFormGroupView.add(formGroupInputTextWarn)

        val formGroupInputTextError = FormGroupInputText(stateFormGroupView.newChildId(), Model(""), Model("Error"))
        formGroupInputTextError.formComponent.error("Error message")
        formGroupInputTextError.add(CssClassAppender(Spacing.MARGIN_BOTTOM_FULL))
        stateFormGroupView.add(formGroupInputTextError)

        val formGroupView = RepeatingView("formGroup")
        form.add(formGroupView)
        val validationFormGroup = FormGroupInputEmail(
            formGroupView.newChildId(),
            Model(""),
            Model("Validation (email)")
        )
        validationFormGroup.setRequired(true)
        validationFormGroup.addAjaxValidation("input")
        validationFormGroup.add(CssClassAppender(Spacing.MARGIN_BOTTOM_FULL))
        formGroupView.add(validationFormGroup)

        val ajaxValidationFormGroup = FormGroupInputEmail(
            formGroupView.newChildId(),
            Model("Type to see what's happening"),
            Model("Ajax Validation (email)")
        )
        ajaxValidationFormGroup.setRequired(true)
        ajaxValidationFormGroup.addAjaxValidation("input")
        ajaxValidationFormGroup.add(CssClassAppender(Spacing.MARGIN_BOTTOM_FULL))
        formGroupView.add(ajaxValidationFormGroup)

        val formGroupActions: FormGroupActions<Void> = object : FormGroupActions<Void>(formGroupView.newChildId()) {
            override fun populateActions(actionView: RepeatingView) {
                val submitButton: AjaxSubmitButton = object : AjaxSubmitButton(actionView.newChildId()) {
                    override fun onSubmit(target: AjaxRequestTarget) {
                        this.success("Your form is valid")
                        target.add(feedbackPanel)
                        target.add(this.form)
                    }
                }
                submitButton.body = Model.of("Submit")
                actionView.add(submitButton)
            }
        }
        formGroupView.add(formGroupActions)
    }
}