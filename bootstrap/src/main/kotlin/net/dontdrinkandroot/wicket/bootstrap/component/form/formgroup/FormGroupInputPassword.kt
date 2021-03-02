package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupPassword
import org.apache.wicket.Component
import org.apache.wicket.markup.html.form.PasswordTextField
import org.apache.wicket.model.IModel

class FormGroupInputPassword<T : String?>(id: String, model: IModel<T>, labelModel: IModel<String>) :
    FormGroupInputGroup<T, String, PasswordTextField, InputGroupPassword<T>>(id, model, labelModel) {

    override fun createInputGroup(id: String): InputGroup<T, String, PasswordTextField> {
        return object : InputGroupPassword<T>(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupInputPassword.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupInputPassword.createInputGroupAppend(id)
            }
        }
    }
}