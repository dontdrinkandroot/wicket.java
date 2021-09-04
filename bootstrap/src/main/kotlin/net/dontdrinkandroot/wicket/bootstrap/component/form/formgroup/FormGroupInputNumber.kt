package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupNumber
import net.dontdrinkandroot.wicket.model.localize
import net.dontdrinkandroot.wicket.model.writeableProperty
import org.apache.wicket.Component
import org.apache.wicket.bean.validation.PropertyValidator
import org.apache.wicket.markup.html.form.NumberTextField
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.validation.IValidator
import kotlin.reflect.KMutableProperty1

/**
 * @param <N> Type of the Number.
 */
class FormGroupInputNumber<N>(id: String, model: IModel<N>, labelModel: IModel<String>) :
    FormGroupInputGroup<N, N, NumberTextField<N>, InputGroupNumber<N>>(id, model, labelModel)
        where N : Number, N : Comparable<N> {

    override fun createInputGroup(id: String): InputGroupNumber<N> {
        return object : InputGroupNumber<N>(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupInputNumber.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupInputNumber.createInputGroupAppend(id)
            }
        }
    }
}

inline fun <N> RepeatingView.addInputNumber(
    model: IModel<N>,
    label: IModel<String>,
    required: Boolean = false,
    ajaxValidation: Boolean = false,
    formText: String? = null,
    validators: List<IValidator<N>> = emptyList()
): FormGroupInputNumber<N> where N : Number, N : Comparable<N> {
    val formGroup = FormGroupInputNumber(newChildId(), model, label).apply {
        setRequired(required)
        if (ajaxValidation) addAjaxValidation()
        formText?.let { setFormText(formText) }
        validators.forEach { addValidator(it) }
    }
    add(formGroup)
    return formGroup
}

inline fun <reified P, N> RepeatingView.addInputNumber(
    model: IModel<P>,
    property: KMutableProperty1<P, N>,
    ajaxValidation: Boolean = false,
    formText: String? = null,
): FormGroupInputNumber<N> where N : Number, N : Comparable<N> {
    val resourceKey = "${P::class.qualifiedName}.${property.name}"
    val formGroup =
        FormGroupInputNumber(newChildId(), model.writeableProperty(property), localize(resourceKey)).apply {
            if (ajaxValidation) addAjaxValidation()
            formText?.let { setFormText(formText) }
            addValidator(PropertyValidator())
        }
    add(formGroup)
    return formGroup
}