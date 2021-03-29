package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class ButtonLink<T>(id: String, model: IModel<T>? = null) : Link<T>(id, model) {

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "button"
        tag.attributes["type"] = "button"
        super.onComponentTag(tag)
    }
}

inline fun buttonLink(
    id: String,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
): Link<Void> {
    return object : ButtonLink<Void>(id) {
        override fun onClick() {
            onClickHandler(this)
        }
    }.apply {
        body = label
        add(*behaviors)
    }
}

inline fun MarkupContainer.addButtonLink(
    id: String,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
): Link<Void> {
    val link = buttonLink(id, label, behaviors = behaviors, onClickHandler)
    add(link)
    return link
}