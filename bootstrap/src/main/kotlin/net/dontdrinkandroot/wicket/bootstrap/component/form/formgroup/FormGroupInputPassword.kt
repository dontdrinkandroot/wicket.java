package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupPassword
import org.apache.wicket.Component
import org.apache.wicket.markup.html.form.PasswordTextField
import org.apache.wicket.model.IModel

class FormGroupInputPassword(id: String, model: IModel<String>, labelModel: IModel<String>) :
    FormGroupInputGroup<String, String, PasswordTextField, InputGroupPassword>(id, labelModel, model) {

    override fun createInputGroup(id: String): InputGroup<String, String, PasswordTextField> {
        return object : InputGroupPassword(id, model) {
            override fun createInputGroupPrepend(id: String): Component {
                return this@FormGroupInputPassword.createInputGroupPrepend(id)
            }

            override fun createInputGroupAppend(id: String): Component {
                return this@FormGroupInputPassword.createInputGroupAppend(id)
            }
        }
    }
}