package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 */
open class FormGroupActions<T>(
    id: String,
    model: IModel<T> = IModel<T> { null },
    labelModel: IModel<String> = Model(null)
) :
    FormGroup<T>(id, model, labelModel) {

    private lateinit var actionView: RepeatingView

    override fun createComponents() {
        super.createComponents()
        actionView = RepeatingView("action")
        populateActions(actionView)
    }

    override fun addComponents() {
        super.addComponents()
        container.add(actionView)
    }

    protected open fun populateActions(actionView: RepeatingView) {
        /* Hook */
    }
}