package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

inline fun <T> ajaxButtonLink(
    id: String,
    model: IModel<T>? = null,
    behaviors: List<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null),
    crossinline onClickHandler: AjaxLink<T>.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxLink<T>(id, model) {
    init {
        body = bodyModel
        behaviors.forEach { add(it) }
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
    }

    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}

inline fun ajaxButtonLink(
    id: String,
    bodyModel: IModel<String> = Model(null),
    buttonStyle: ButtonStyle = ButtonStyle.SECONDARY,
    buttonSize: ButtonSize? = null,
    crossinline onClickHandler: AjaxLink<Any>.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxLink<Any>(id) {
    init {
        body = bodyModel
        behaviors.forEach { add(it) }
        add(ButtonBehavior(Model(buttonStyle), Model(buttonSize)))
    }

    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}