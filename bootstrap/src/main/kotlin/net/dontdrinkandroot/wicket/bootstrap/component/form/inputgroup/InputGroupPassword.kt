package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.markup.html.form.PasswordTextField
import org.apache.wicket.model.IModel

open class InputGroupPassword<T : String?>(id: String, model: IModel<T>? = null) :
    InputGroup<T, String, PasswordTextField>(id, model) {

    override fun createFormComponent(id: String): PasswordTextField {
        val formComponent: PasswordTextField = object : PasswordTextField(id, this.model as IModel<String>) {
            override fun onComponentTag(tag: ComponentTag) {
                tag.put("type", "password")
                super.onComponentTag(tag)
            }
        }
        formComponent.add(HTML5Attributes())
        return formComponent
    }
}