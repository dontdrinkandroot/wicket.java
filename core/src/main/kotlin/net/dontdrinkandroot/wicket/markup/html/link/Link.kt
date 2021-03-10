package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

inline fun <T> createLink(
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

inline fun createLink(
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

inline fun <T> MarkupContainer.link(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<T>.() -> Any?
) {
    add(createLink(id, model, label, behaviors = behaviors, onClickHandler))
}

inline fun MarkupContainer.link(
    id: String,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
) {
    add(createLink(id, label, behaviors = behaviors, onClickHandler))
}