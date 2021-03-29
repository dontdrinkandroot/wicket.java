package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.model.localize
import net.dontdrinkandroot.wicket.model.writeableProperty
import org.apache.wicket.bean.validation.PropertyValidator
import org.apache.wicket.behavior.AttributeAppender
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.markup.html.form.TextArea
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import kotlin.reflect.KMutableProperty1

/**
 * @param <T> Type of the model object.
 */
class FormGroupTextArea<T>(id: String, model: IModel<T>, labelModel: IModel<String>) :
    FormGroupFormComponent<T, T, TextArea<T>>(id, model, labelModel) {

    val rows = 5

    override fun createFormComponent(id: String): TextArea<T> {
        val textArea = TextArea(id, model)
        textArea.add(AttributeAppender("rows") { rows })
        textArea.add(HTML5Attributes())
        return textArea
    }
}

inline fun <reified P, T : String?> RepeatingView.addTextArea(
    model: IModel<P>,
    property: KMutableProperty1<P, T>,
    ajaxValidation: Boolean = false,
    formText: String? = null,
): FormGroupTextArea<T> {
    val resourceKey = P::class.qualifiedName + "." + property.name
    val formGroupInputText =
        FormGroupTextArea(newChildId(), model.writeableProperty(property), localize(resourceKey)).apply {
            if (ajaxValidation) addAjaxValidation()
            formText?.let { setFormText(formText) }
            addValidator(PropertyValidator())
        }
    add(formGroupInputText)
    return formGroupInputText
}