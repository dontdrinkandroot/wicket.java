package net.dontdrinkandroot.wicket.behavior.ajax

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior

inline fun ajaxUpdate(
    event: String,
    crossinline onUpdateHandler: AjaxFormComponentUpdatingBehavior.(target: AjaxRequestTarget) -> Any?
): AjaxFormComponentUpdatingBehavior = object : AjaxFormComponentUpdatingBehavior(event) {
    override fun onUpdate(target: AjaxRequestTarget) {
        onUpdateHandler(this, target)
    }
}