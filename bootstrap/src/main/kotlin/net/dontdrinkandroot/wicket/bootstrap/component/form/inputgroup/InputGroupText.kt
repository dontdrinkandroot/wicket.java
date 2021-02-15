package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.IModel

open class InputGroupText(id: String, model: IModel<String>? = null) :
    InputGroup<String, String, TextField<String>>(id, model) {

    override fun createFormComponent(id: String): TextField<String> {
        val formComponent: TextField<String> = object : TextField<String>(id, this.model, String::class.java) {
            override fun onComponentTag(tag: ComponentTag) {
                tag.put("type", "text")
                super.onComponentTag(tag)
            }
        }
        formComponent.add(HTML5Attributes())
        return formComponent
    }
}