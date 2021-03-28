package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

inline fun <T> link(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<T>.() -> Any?
) = object : Link<T>(id, model) {
    override fun onClick() {
        onClickHandler(this)
    }
}.apply {
    body = label
    add(*behaviors)
}

inline fun link(
    id: String,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
) = object : Link<Void>(id) {
    override fun onClick() {
        onClickHandler(this)
    }
}.apply {
    body = label
    add(*behaviors)
}

inline fun <T> MarkupContainer.addLink(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<T>.() -> Any?
): Link<T> {
    val link = link(id, model, label, behaviors = behaviors, onClickHandler)
    add(link)
    return link
}

inline fun MarkupContainer.addLink(
    id: String,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
): Link<Void> {
    val link = link(id, label, behaviors = behaviors, onClickHandler)
    add(link)
    return link
}

inline fun MarkupContainer.addLink(
    id: String,
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
): Link<Void> {
    val link = link(id, Model(null), behaviors = behaviors, onClickHandler)
    add(link)
    return link
}