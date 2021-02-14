package net.dontdrinkandroot.wicket.bootstrap.component.modal

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.IModel

abstract class AjaxFormModal<T>(id: String, model: IModel<T>? = null) : FormModal<T>(id, model) {

    override fun createForm(id: String): Form<T> {
        val form = Form<T>(id)
        form.add(object : AjaxFormSubmitBehavior(form, "submit") {
            override fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
                super.updateAjaxAttributes(attributes)
                attributes.isPreventDefault = true
            }

            override fun onError(target: AjaxRequestTarget) {
                super.onError(target)
                this@AjaxFormModal.onError(target)
            }

            override fun onSubmit(target: AjaxRequestTarget) {
                super.onSubmit(target)
                this@AjaxFormModal.onSubmit(target)
            }

            override fun onAfterSubmit(target: AjaxRequestTarget) {
                super.onAfterSubmit(target)
                this@AjaxFormModal.onAfterSubmit(target)
            }
        })
        return form
    }

    override fun onError() {
        if (!this.requestCycle.find(AjaxRequestTarget::class.java).isPresent) {
            this.onError(null)
        }
    }

    override fun onSubmit() {
        if (!this.requestCycle.find(AjaxRequestTarget::class.java).isPresent) {
            this.onSubmit(null)
            onAfterSubmit(null)
        }
    }

    /**
     * Hook for handling the submission with Ajax. Do not perform any setResponsePage Actions here, as they will lead
     * to a double subission. Use onAfterSubmit instead.
     *
     * @param target The current AjaxRequestTarget or null if not submitted via ajax
     * @see AjaxFormSubmitBehavior.onSubmit
     */
    protected fun onSubmit(target: AjaxRequestTarget?) {
        /* Hook */
    }

    /**
     * @see AjaxFormSubmitBehavior.onAfterSubmit
     */
    protected fun onAfterSubmit(target: AjaxRequestTarget?) {
        target?.appendJavaScript(hideScript)
    }

    /**
     * @see AjaxFormSubmitBehavior.onError
     */
    protected open fun onError(target: AjaxRequestTarget?) {
        target?.add(form)
    }
}