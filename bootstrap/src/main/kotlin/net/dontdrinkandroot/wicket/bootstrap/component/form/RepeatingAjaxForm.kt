package net.dontdrinkandroot.wicket.bootstrap.component.form

import org.apache.wicket.MarkupContainer
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

open class RepeatingAjaxForm<T> constructor(id: String, model: IModel<T>? = null) : RepeatingForm<T>(id, model) {

    init {
        createSubmitBehavior()
    }

    protected fun createSubmitBehavior() {
        this.add(object : AjaxFormSubmitBehavior(this, "submit") {
            override fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
                super.updateAjaxAttributes(attributes)
                attributes.isPreventDefault = true
                this@RepeatingAjaxForm.updateAjaxAttributes(attributes)
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
        val target = this.requestCycle.find(AjaxRequestTarget::class.java)
        if (!target.isPresent) {
            this.onError(null)
        }
    }

    override fun onSubmit() {
        val target = this.requestCycle.find(AjaxRequestTarget::class.java)
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

    protected open fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
        /* Hook */
    }

    protected open fun onError(target: AjaxRequestTarget?) {
        target?.add(this)
    }
}

inline fun MarkupContainer.addAjaxForm(
    id: String,
    crossinline formGroups: RepeatingView.(component: RepeatingAjaxForm<Void>) -> Any?,
    crossinline updateAjaxAttributesHandler: AjaxRequestAttributes.(form: RepeatingAjaxForm<Void>) -> Unit = {},
    vararg behaviors: Behavior,
    crossinline submit: RepeatingAjaxForm<Void>.(target: AjaxRequestTarget?) -> Any? = {}
): RepeatingForm<Void> {
    val form = object : RepeatingAjaxForm<Void>(id) {

        override fun populateFormGroups(formGroupView: RepeatingView) {
            formGroups(formGroupView, this)
        }

        override fun onSubmit(target: AjaxRequestTarget?) {
            submit(target)
        }

        override fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
            updateAjaxAttributesHandler(attributes, this)
        }

    }.apply {
        add(*behaviors)
    }
    add(form)
    return form
}