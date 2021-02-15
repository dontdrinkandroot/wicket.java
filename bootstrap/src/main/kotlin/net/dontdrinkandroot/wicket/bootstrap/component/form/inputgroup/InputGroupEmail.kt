package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.markup.html.form.EmailTextField
import org.apache.wicket.model.IModel

open class InputGroupEmail(id: String, model: IModel<String>? = null) :
    InputGroup<String, String, EmailTextField>(id, model) {

    override fun createFormComponent(id: String): EmailTextField {
        val formComponent: EmailTextField = object : EmailTextField(id, this.model) {
            override fun onComponentTag(tag: ComponentTag) {
                tag.put("type", "email")
                super.onComponentTag(tag)
            }
        }
        formComponent.add(HTML5Attributes())
        return formComponent
    }
}