package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupEmail
import org.apache.wicket.Component
import org.apache.wicket.markup.html.form.EmailTextField
import org.apache.wicket.model.IModel

class FormGroupInputEmail<T : String?>(id: String, model: IModel<T>, labelModel: IModel<String>) :
    FormGroupInputGroup<T, String, EmailTextField, InputGroupEmail<T>>(id, model, labelModel) {

    override fun createInputGroup(id: String): InputGroupEmail<T> {
        return object : InputGroupEmail<T>(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupInputEmail.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupInputEmail.createInputGroupAppend(id)
            }
        }
    }
}