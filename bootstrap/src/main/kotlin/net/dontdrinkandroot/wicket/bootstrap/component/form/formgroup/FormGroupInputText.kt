package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupText
import org.apache.wicket.Component
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

open class FormGroupInputText<T : String?>(id: String, model: IModel<T>, labelModel: IModel<String>) :
    FormGroupInputGroup<T, T, TextField<T>, InputGroupText<T>>(id, model, labelModel) {

    override fun createInputGroup(id: String): InputGroupText<T> {
        return object : InputGroupText<T>(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupInputText.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupInputText.createInputGroupAppend(id)
            }
        }
    }
}

inline fun <T : String?> RepeatingView.addInputText(
    model: IModel<T>,
    label: IModel<String>,
    required: Boolean = false,
    ajaxValidation: Boolean = false,
    helpText: String? = null
): FormGroupInputText<T> {
    val formGroupInputText = FormGroupInputText(newChildId(), model, label).apply {
        setRequired(required)
        if (ajaxValidation) addAjaxValidation()
        helpText?.let { setHelpText(helpText) }
    }
    add(formGroupInputText)
    return formGroupInputText
}