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
) = object : AjaxLink<T>(id, model) {
    init {
        body = label
        add(*behaviors)
    }

    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}

inline fun <T> MarkupContainer.addAjaxLink(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<T>.(target: AjaxRequestTarget?) -> Any?
) {
    add(ajaxLink(id, model, label, behaviors = behaviors, onClickHandler))
}

inline fun MarkupContainer.addAjaxLink(
    id: String,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<Void>.(target: AjaxRequestTarget?) -> Any?
) {
    add(ajaxLink(id, null, label, behaviors = behaviors, onClickHandler))
}

inline fun MarkupContainer.addAjaxLink(
    id: String,
    vararg behaviors: Behavior,
    crossinline onClickHandler: AjaxLink<Void>.(target: AjaxRequestTarget?) -> Any?
) {
    add(ajaxLink(id, null, Model(null), behaviors = behaviors, onClickHandler))
}