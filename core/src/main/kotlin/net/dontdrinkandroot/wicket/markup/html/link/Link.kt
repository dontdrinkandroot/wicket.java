package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.markup.html.link.Link as WicketLink

abstract class Link<T>(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
) : WicketLink<T>(id, model) {

    init {
        body = bodyModel
        behaviors.forEach { this.add(it) }
    }
}

fun <T> link(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    onClickHandler: Link<T>.() -> Any?
) = object : Link<T>(id, model, behaviors = behaviors, bodyModel = bodyModel) {
    override fun onClick() {
        onClickHandler(this)
    }
}