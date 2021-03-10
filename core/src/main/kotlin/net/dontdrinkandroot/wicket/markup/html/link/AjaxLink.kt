package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.MarkupContainer
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

inline fun <T> createAjaxLink(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<T>.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxLink<T>(id, model) {
    init {
        body = bodyModel
        add(*behaviors)
    }

    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}

inline fun <T> MarkupContainer.ajaxLink(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<T>.(target: AjaxRequestTarget?) -> Any?
) {
    add(createAjaxLink(id, model, bodyModel, behaviors = behaviors, onClickHandler))
}

inline fun MarkupContainer.ajaxLink(
    id: String,
    bodyModel: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<Void>.(target: AjaxRequestTarget?) -> Any?
) {
    add(createAjaxLink(id, null, bodyModel, behaviors = behaviors, onClickHandler))
}

inline fun MarkupContainer.ajaxLink(
    id: String,
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<Void>.(target: AjaxRequestTarget?) -> Any?
) {
    add(createAjaxLink(id, null, Model(null), behaviors = behaviors, onClickHandler))
}