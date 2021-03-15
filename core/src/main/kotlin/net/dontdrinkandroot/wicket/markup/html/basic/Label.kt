package net.dontdrinkandroot.wicket.markup.html.basic

import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel

@Deprecated("Use createLabel instead")
class Label<T>(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior
) : Label(id, model) {

    init {
        add(*behaviors)
    }
}

fun <T> label(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior
) = object : Label(id, model) {

    init {
        add(*behaviors)
    }
}

fun <T> MarkupContainer.addLabel(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior
) {
    add(label(id, model, *behaviors))
}