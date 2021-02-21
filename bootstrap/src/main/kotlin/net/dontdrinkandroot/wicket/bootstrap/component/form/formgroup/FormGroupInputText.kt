package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupText
import org.apache.wicket.Component
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.IModel

open class FormGroupInputText(id: String, model: IModel<String>, labelModel: IModel<String>) :
    FormGroupInputGroup<String, String, TextField<String>, InputGroupText>(id, model, labelModel) {

    override fun createInputGroup(id: String): InputGroupText {
        return object : InputGroupText(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupInputText.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupInputText.createInputGroupAppend(id)
            }
        }
    }
}