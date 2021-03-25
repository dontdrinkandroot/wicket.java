package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import org.apache.wicket.markup.html.form.FormComponent
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the Model Object.
 * @param <M> Type of the FormComponent Model Object.
 * @param <F> Type of the [FormComponent]
 */
abstract class FormGroupFormComponent<T, M, F : FormComponent<M>> constructor(
    id: String,
    model: IModel<T>,
    labelModel: IModel<String>,
    protected val type: Class<T>? = null
) : FormGroupValidatable<T, M, F>(id, model, labelModel) {

    override lateinit var formComponent: F
        protected set

    init {
        this.outputMarkupId = true

        /* Initialize form component early, so it is available before onInitialize takes place */
        formComponent = createFormComponent("formComponent")
        formComponent.outputMarkupId = true
        formComponent.label = this.labelModel
    }

    override fun addComponents() {
        super.addComponents()
        container.add(formComponent)
        container.add(validationFeedbackPanel)
    }

    protected abstract fun createFormComponent(id: String): F
}