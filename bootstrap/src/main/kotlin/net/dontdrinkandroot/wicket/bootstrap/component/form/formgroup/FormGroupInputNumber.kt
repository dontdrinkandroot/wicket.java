package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupNumber
import org.apache.wicket.Component
import org.apache.wicket.markup.html.form.NumberTextField
import org.apache.wicket.model.IModel

/**
 * @param <N> Type of the Number.
 */
class FormGroupInputNumber<N>(id: String, model: IModel<N>, labelModel: IModel<String>) :
    FormGroupInputGroup<N, N, NumberTextField<N>, InputGroupNumber<N>>(id, labelModel, model)
        where N : Number, N : Comparable<N> {

    override fun createInputGroup(id: String): InputGroupNumber<N> {
        return object : InputGroupNumber<N>(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupInputNumber.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupInputNumber.createInputGroupAppend(id)
            }
        }
    }
}