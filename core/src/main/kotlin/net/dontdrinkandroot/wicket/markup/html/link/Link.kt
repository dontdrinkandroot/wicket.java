package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

inline fun <T> link(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<T>.() -> Any?
) = object : Link<T>(id, model) {
    init {
        body = bodyModel
        add(*behaviors)
    }

    override fun onClick() {
        onClickHandler(this)
    }
}

inline fun link(
    id: String,
    bodyModel: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
) = object : Link<Void>(id) {
    init {
        body = bodyModel
        add(*behaviors)
    }

    override fun onClick() {
        onClickHandler(this)
    }
}