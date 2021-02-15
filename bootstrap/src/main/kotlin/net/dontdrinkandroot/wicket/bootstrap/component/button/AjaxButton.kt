package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 */
abstract class AjaxButton<T>(
    id: String,
    model: IModel<T>? = null,
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : AjaxLink<T>(id, model) {

    init {
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
    }
}