package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.Component
import org.apache.wicket.ajax.attributes.AjaxCallListener
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class DisablingSubmitButton(
    id: String,
    form: Form<*>? = null,
    labelModel: IModel<String>? = null,
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.PRIMARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : AjaxSubmitButton(id, form, labelModel, buttonStyleModel, buttonSizeModel) {

    override fun updateAjaxAttributes(attributes: AjaxRequestAttributes) {
        super.updateAjaxAttributes(attributes)
        attributes.ajaxCallListeners.add(DisablingAjaxCallListener())
    }

    private inner class DisablingAjaxCallListener : AjaxCallListener() {

        override fun getAfterHandler(component: Component): CharSequence {
            val formMarkupId = form.markupId
            val builder = StringBuilder()
            builder.append(String.format("$('#%s input').attr('disabled', 'disabled');", formMarkupId))
            builder.append(String.format("$('#%s textarea').attr('disabled', 'disabled');", formMarkupId))
            builder.append(String.format("$('#%s select').attr('disabled', 'disabled');", formMarkupId))
            return builder.toString()
        }

        override fun getCompleteHandler(component: Component): CharSequence {
            val formMarkupId = form.markupId
            val builder = StringBuilder()
            builder.append(String.format("$('#%s input').removeAttr('disabled', 'disabled');", formMarkupId))
            builder.append(String.format("$('#%s textarea').removeAttr('disabled', 'disabled');", formMarkupId))
            builder.append(String.format("$('#%s select').removeAttr('disabled', 'disabled');", formMarkupId))
            return builder.toString()
        }
    }
}