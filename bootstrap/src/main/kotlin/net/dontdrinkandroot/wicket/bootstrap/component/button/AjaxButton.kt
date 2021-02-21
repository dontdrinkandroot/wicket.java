package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.markup.html.link.AjaxLink
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 */
class AjaxButton<T>(
    id: String,
    model: IModel<T>? = null,
    behaviors: List<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    onClickHandler: AjaxLink<T>.(target: AjaxRequestTarget?) -> Any?,
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : AjaxLink<T>(id, model, behaviors, bodyModel, onClickHandler) {

    init {
        behaviors.forEach { add(it) }
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
    }
}