package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.markup.html.form.EmailTextField
import org.apache.wicket.model.IModel

open class InputGroupEmail<T : String?>(id: String, model: IModel<T>? = null) :
    InputGroup<T, String, EmailTextField>(id, model) {

    override fun createFormComponent(id: String): EmailTextField {
        val formComponent: EmailTextField = object : EmailTextField(id, this.model as IModel<String>) {
            override fun onComponentTag(tag: ComponentTag) {
                tag.put("type", "email")
                super.onComponentTag(tag)
            }
        }
        formComponent.add(HTML5Attributes())
        return formComponent
    }
}