package net.dontdrinkandroot.wicket.bootstrap.behavior.form

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupValidatable
import net.dontdrinkandroot.wicket.bootstrap.css.ValidationState
import net.dontdrinkandroot.wicket.javascript.JQueryScript
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes
import org.apache.wicket.ajax.attributes.ThrottlingSettings
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior

/**
 * Ajax Validation state that colors the [FormGroupValidatable] according to the validation state and shows
 * any error messages.
 */
class FormGroupAjaxValidationBehavior(
    event: String,
    private val formGroup: FormGroupValidatable<*, *, *>,
    private var throttlingSettings: ThrottlingSettings? = null
) : AjaxFormComponentUpdatingBehavior(event) {

    override fun onUpdate(target: AjaxRequestTarget) {
        renderValidation(target)
    }

    override fun onError(target: AjaxRequestTarget, e: RuntimeException?) {
        super.onError(target, e)
        renderValidation(target)
    }

    protected fun renderValidation(target: AjaxRequestTarget) {
        target.appendJavaScript(JQueryScript(formGroup.formComponent).removeClass(ValidationState.INVALID.classString))
        target.appendJavaScript(JQueryScript(formGroup.formComponent).removeClass(ValidationState.VALID.classString))
        var validationState = formGroup.validationState
        if (null == validationState && formGroup.formComponent.isValid) {
            validationState = ValidationState.VALID
        }
        if (null != validationState) {
            target.appendJavaScript(
                JQueryScript(formGroup.formComponent).addClass(validationState.classString).toString()
            )
            target.add(formGroup.validationFeedbackPanel)
        }
    }

    override fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
        super.updateAjaxAttributes(attributes)
        if (null != throttlingSettings) {
            attributes.throttlingSettings = throttlingSettings
        }
    }
}