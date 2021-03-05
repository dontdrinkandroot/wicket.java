package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

open class AjaxSubmitButton(
    id: String,
    form: Form<*>? = null,
    labelModel: IModel<String>? = null,
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.PRIMARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : AjaxSubmitLink(id, form) {

    init {
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
        body = labelModel
    }

    override fun onError(target: AjaxRequestTarget) {
        super.onError(target)
        target.add(form)
    }
}