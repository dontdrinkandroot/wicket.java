package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.markup.html.form.UrlTextField
import org.apache.wicket.model.IModel

open class InputGroupUrl(id: String, model: IModel<String>? = null) :
    InputGroup<String, String, UrlTextField>(id, model) {

    override fun createFormComponent(id: String): UrlTextField {
        val formComponent: UrlTextField = object : UrlTextField(id, this.model) {
            override fun onComponentTag(tag: ComponentTag) {
                tag.put("type", "url")
                super.onComponentTag(tag)
            }
        }
        formComponent.add(HTML5Attributes())
        return formComponent
    }
}