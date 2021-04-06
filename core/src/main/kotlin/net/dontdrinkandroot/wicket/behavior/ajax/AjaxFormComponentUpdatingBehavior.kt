package net.dontdrinkandroot.wicket.behavior.ajax

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior
import org.apache.wicket.util.lang.Checks

inline fun ajaxUpdate(
    event: String,
    crossinline updateAjaxAttributesHandler: AjaxRequestAttributes.(behavior: AjaxFormComponentUpdatingBehavior) -> Unit = {},
    crossinline onUpdateHandler: AjaxFormComponentUpdatingBehavior.(target: AjaxRequestTarget) -> Unit
): AjaxFormComponentUpdatingBehavior = object : AjaxFormComponentUpdatingBehavior(event) {
    override fun onUpdate(target: AjaxRequestTarget) {
        onUpdateHandler(this, target)
    }

    override fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
        val evt = this.event
        Checks.notEmpty(evt, "getEvent() should return non-empty event name(s)", *arrayOfNulls(0))
        attributes.setEventNames(*arrayOf(evt))
        attributes.method = AjaxRequestAttributes.Method.POST
        updateAjaxAttributesHandler(attributes, this)
    }
}