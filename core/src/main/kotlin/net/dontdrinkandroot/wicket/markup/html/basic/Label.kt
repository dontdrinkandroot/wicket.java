package net.dontdrinkandroot.wicket.markup.html.basic

import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel

fun <T> label(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior
) = Label(id, model).apply { add(*behaviors) }

fun <T> MarkupContainer.addLabel(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior
): Label {
    val label = label(id, model, *behaviors)
    add(label)
    return label
}