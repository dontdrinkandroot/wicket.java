package net.dontdrinkandroot.wicket.markup.html

import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.GenericWebMarkupContainer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.IModel

fun markupContainer(
    id: String,
    vararg behaviors: Behavior,
) = WebMarkupContainer(id).apply { add(*behaviors) }

fun <T> markupContainer(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior,
) = GenericWebMarkupContainer<T>(id, model).apply { add(*behaviors) }

fun MarkupContainer.addMarkupContainer(
    id: String,
    vararg behaviors: Behavior,
) {
    add(markupContainer(id, *behaviors))
}