package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

inline fun <T> ajaxButtonLink(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.SECONDARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<T>.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxLink<T>(id, model) {
    init {
        body = bodyModel
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
        add(*behaviors)
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
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<Any>.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxLink<Any>(id) {
    init {
        body = bodyModel
        add(ButtonBehavior(Model(buttonStyle), Model(buttonSize)))
        add(*behaviors)
    }

    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}