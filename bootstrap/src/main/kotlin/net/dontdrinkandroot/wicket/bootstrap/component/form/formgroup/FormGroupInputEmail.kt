package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupEmail
import net.dontdrinkandroot.wicket.model.localize
import net.dontdrinkandroot.wicket.model.writeableProperty
import org.apache.wicket.Component
import org.apache.wicket.bean.validation.PropertyValidator
import org.apache.wicket.markup.html.form.EmailTextField
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import kotlin.reflect.KMutableProperty1

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

inline fun <reified P, T : String?> RepeatingView.addInputEmail(
    model: IModel<P>,
    property: KMutableProperty1<P, T>,
    ajaxValidation: Boolean = false,
    formText: String? = null,
): FormGroupInputEmail<T> {
    val resourceKey = "${P::class.qualifiedName}.${property.name}"
    val formGroup =
        FormGroupInputEmail(newChildId(), model.writeableProperty(property), localize(resourceKey)).apply {
            if (ajaxValidation) addAjaxValidation()
            formText?.let { setFormText(formText) }
            addValidator(PropertyValidator())
        }
    add(formGroup)
    return formGroup
}