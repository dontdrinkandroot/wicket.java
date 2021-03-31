package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.MarkupContainer
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

inline fun <T> ajaxLink(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<T>.(target: AjaxRequestTarget?) -> Any?
): AjaxLink<T> = object : AjaxLink<T>(id, model) {
    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}.apply {
    body = label
    add(*behaviors)
}

inline fun <T> MarkupContainer.addAjaxLink(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<T>.(target: AjaxRequestTarget?) -> Any?
): AjaxLink<T> {
    val ajaxLink = ajaxLink(id, model, label, behaviors = behaviors, onClickHandler)
    add(ajaxLink)
    return ajaxLink
}

inline fun MarkupContainer.addAjaxLink(
    id: String,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<Void>.(target: AjaxRequestTarget?) -> Any?
): AjaxLink<Void> {
    val ajaxLink = ajaxLink(id, null, label, behaviors = behaviors, onClickHandler)
    add(ajaxLink)
    return ajaxLink
}

inline fun MarkupContainer.addAjaxLink(
    id: String,
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<Void>.(target: AjaxRequestTarget?) -> Any?
): AjaxLink<Void> {
    val ajaxLink = ajaxLink(id, null, Model(null), behaviors = behaviors, onClickHandler)
    add(ajaxLink)
    return ajaxLink
}