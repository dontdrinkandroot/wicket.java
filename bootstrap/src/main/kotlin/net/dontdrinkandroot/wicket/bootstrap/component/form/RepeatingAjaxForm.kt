package net.dontdrinkandroot.wicket.bootstrap.component.form

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior
import org.apache.wicket.model.IModel

open class RepeatingAjaxForm<T> constructor(id: String, model: IModel<T>? = null) :
    RepeatingForm<T>(id, model) {

    init {
        createSubmitBehavior()
    }

    protected fun createSubmitBehavior() {
        this.add(object : AjaxFormSubmitBehavior(this, "submit") {
            override fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
                super.updateAjaxAttributes(attributes)
                attributes.isPreventDefault = true
            }

            override fun onError(target: AjaxRequestTarget) {
                super.onError(target)
                this@RepeatingAjaxForm.onError(target)
            }

            override fun onSubmit(target: AjaxRequestTarget) {
                super.onSubmit(target)
                this@RepeatingAjaxForm.onSubmit(target)
            }

            override fun onAfterSubmit(target: AjaxRequestTarget) {
                super.onAfterSubmit(target)
                this@RepeatingAjaxForm.onAfterSubmit(target)
            }
        })
    }

    override fun onError() {
        val target = this.requestCycle.find(
            AjaxRequestTarget::class.java
        )
        if (!target.isPresent) {
            this.onError(null)
        }
    }

    override fun onSubmit() {
        val target = this.requestCycle.find(
            AjaxRequestTarget::class.java
        )
        if (!target.isPresent) {
            this.onSubmit(null)
            onAfterSubmit(null)
        }
    }

    /**
     * Hook for handling the submission with Ajax. Do not perform any setResponsePage Actions here, as they will lead
     * to a double submission. Use onAfterSubmit instead.
     *
     * @param target The current AjaxRequestTarget or null if non was found
     */
    protected open fun onSubmit(target: AjaxRequestTarget?) {
        /* Hook */
    }

    protected open fun onAfterSubmit(target: AjaxRequestTarget?) {
        /* Hook */
    }

    protected open fun onError(target: AjaxRequestTarget?) {
        target?.add(this)
    }
}