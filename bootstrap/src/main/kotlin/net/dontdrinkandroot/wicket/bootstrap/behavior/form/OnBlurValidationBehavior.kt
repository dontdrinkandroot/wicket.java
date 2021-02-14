package net.dontdrinkandroot.wicket.bootstrap.behavior.form

import org.apache.wicket.Component
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior

class OnBlurValidationBehavior(private val targetComponent: Component) : AjaxFormComponentUpdatingBehavior("blur") {

    override fun onUpdate(target: AjaxRequestTarget) {
        target.add(targetComponent)
    }

    override fun onError(target: AjaxRequestTarget, e: RuntimeException) {
        super.onError(target, e)
        target.add(targetComponent)
    }
}