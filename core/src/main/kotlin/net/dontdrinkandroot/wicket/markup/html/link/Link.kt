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
    init {
        body = label
        add(*behaviors)
    }

    override fun onClick() {
        onClickHandler(this)
    }
}

inline fun link(
    id: String,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
) = object : Link<Void>(id) {
    init {
        body = label
        add(*behaviors)
    }

    override fun onClick() {
        onClickHandler(this)
    }
}

inline fun <T> MarkupContainer.addLink(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<T>.() -> Any?
) {
    add(link(id, model, label, behaviors = behaviors, onClickHandler))
}

inline fun MarkupContainer.addLink(
    id: String,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
) {
    add(link(id, label, behaviors = behaviors, onClickHandler))
}

inline fun MarkupContainer.addLink(
    id: String,
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
) {
    add(link(id, Model(null), behaviors = behaviors, onClickHandler))
}