package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupEmail
import org.apache.wicket.Component
import org.apache.wicket.markup.html.form.EmailTextField
import org.apache.wicket.model.IModel

class FormGroupInputEmail(id: String, model: IModel<String>, labelModel: IModel<String>) :
    FormGroupInputGroup<String, String, EmailTextField, InputGroupEmail>(id, labelModel, model) {

    override fun createInputGroup(id: String): InputGroupEmail {
        return object : InputGroupEmail(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupInputEmail.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupInputEmail.createInputGroupAppend(id)
            }
        }
    }
}