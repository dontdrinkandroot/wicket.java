package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.SubmitLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class SubmitButton(
    id: String,
    model: IModel<*>? = null,
    form: Form<*>? = null,
    labelModel: IModel<String>?,
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.PRIMARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : SubmitLink(id, model, form) {

    init {
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
        body = labelModel
    }
}