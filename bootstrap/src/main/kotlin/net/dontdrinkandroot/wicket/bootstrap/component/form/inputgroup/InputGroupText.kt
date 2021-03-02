package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.IModel

open class InputGroupText<T : String?>(id: String, model: IModel<T>? = null) :
    InputGroup<T, T, TextField<T>>(id, model) {

    override fun createFormComponent(id: String): TextField<T> {
        val formComponent: TextField<T> = object : TextField<T>(id, this.model/*, String::class.java*/) {
            override fun onComponentTag(tag: ComponentTag) {
                tag.put("type", "text")
                super.onComponentTag(tag)
            }
        }
        formComponent.add(HTML5Attributes())
        return formComponent
    }
}