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
        behaviors.forEach { this.add(it) }
    }

    override fun onClick() {
        onClickHandler(this)
    }
}