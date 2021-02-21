package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupUrl
import org.apache.wicket.Component
import org.apache.wicket.markup.html.form.UrlTextField
import org.apache.wicket.model.IModel

class FormGroupInputUrl(id: String, model: IModel<String>, labelModel: IModel<String>) :
    FormGroupInputGroup<String, String, UrlTextField, InputGroupUrl>(id, model, labelModel) {

    override fun createInputGroup(id: String): InputGroupUrl {
        return object : InputGroupUrl(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupInputUrl.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupInputUrl.createInputGroupAppend(id)
            }
        }
    }
}