package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * A [Label] with [ButtonBehavior].
 */
class LabelButton(
    id: String,
    model: IModel<*>? = null,
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : Label(id, model) {

    init {
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
    }
}