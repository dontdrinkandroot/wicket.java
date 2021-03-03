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
abstract class AjaxButton<T>(
    id: String,
    model: IModel<T>? = null,
    behaviors: List<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : AjaxLink<T>(id, model, behaviors, bodyModel) {

    init {
        behaviors.forEach { add(it) }
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
    }
}

fun <T> ajaxButton(
    id: String,
    model: IModel<T>? = null,
    behaviors: List<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null),
    onClickHandler: AjaxButton<T>.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxButton<T>(
    id,
    model,
    behaviors = behaviors,
    bodyModel = bodyModel,
    buttonStyleModel = buttonStyleModel,
    buttonSizeModel = buttonSizeModel
) {
    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}

fun ajaxButton(
    id: String,
    bodyModel: IModel<String> = Model(null),
    buttonStyle: ButtonStyle = ButtonStyle.SECONDARY,
    buttonSize: ButtonSize? = null,
    onClickHandler: AjaxButton<Void>.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxButton<Void>(
    id,
    bodyModel = bodyModel,
    buttonStyleModel = Model(buttonStyle),
    buttonSizeModel = Model(buttonSize)
) {
    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}