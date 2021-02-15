package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.markup.html.form.NumberTextField
import org.apache.wicket.model.IModel

/**
 * @param <N> Type of the Number.
 */
open class InputGroupNumber<N>(id: String, model: IModel<N>? = null) :
    InputGroup<N, N, NumberTextField<N>>(id, model) where N : Number, N : Comparable<N> {

    override fun createFormComponent(id: String): NumberTextField<N> {
        val formComponent: NumberTextField<N> = object : NumberTextField<N>(id, this.model) {
            override fun onComponentTag(tag: ComponentTag) {
                tag.put("type", "number")
                super.onComponentTag(tag)
            }
        }
        formComponent.add(HTML5Attributes())
        return formComponent
    }
}