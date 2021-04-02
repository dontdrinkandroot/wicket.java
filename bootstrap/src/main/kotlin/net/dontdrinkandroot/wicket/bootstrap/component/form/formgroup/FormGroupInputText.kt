package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupText
import net.dontdrinkandroot.wicket.model.localize
import net.dontdrinkandroot.wicket.model.writeableProperty
import org.apache.wicket.Component
import org.apache.wicket.bean.validation.PropertyValidator
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.validation.IValidator
import kotlin.reflect.KMutableProperty1

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
    formText: String? = null,
    validators: List<IValidator<T>> = emptyList()
): FormGroupInputText<T> {
    val formGroupInputText = FormGroupInputText(newChildId(), model, label).apply {
        setRequired(required)
        if (ajaxValidation) addAjaxValidation()
        formText?.let { setFormText(formText) }
        validators.forEach { addValidator(it) }
    }
    add(formGroupInputText)
    return formGroupInputText
}

inline fun <reified P, T : String?> RepeatingView.addInputText(
    model: IModel<P>,
    property: KMutableProperty1<P, T>,
    ajaxValidation: Boolean = false,
    formText: String? = null,
): FormGroupInputText<T> {
    val resourceKey = "${P::class.qualifiedName}.${property.name}"
    val formGroupInputText =
        FormGroupInputText(newChildId(), model.writeableProperty(property), localize(resourceKey)).apply {
            if (ajaxValidation) addAjaxValidation()
            formText?.let { setFormText(formText) }
            addValidator(PropertyValidator())
        }
    add(formGroupInputText)
    return formGroupInputText
}