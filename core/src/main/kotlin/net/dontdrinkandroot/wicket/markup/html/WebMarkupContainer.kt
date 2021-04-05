package net.dontdrinkandroot.wicket.markup.html

import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.GenericWebMarkupContainer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.IModel

inline fun markupContainer(id: String, vararg behaviors: Behavior): WebMarkupContainer =
    WebMarkupContainer(id).apply { add(*behaviors) }

inline fun <T> markupContainer(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior
): GenericWebMarkupContainer<T> = GenericWebMarkupContainer<T>(id, model).apply { add(*behaviors) }

inline fun MarkupContainer.addMarkupContainer(id: String, vararg behaviors: Behavior): WebMarkupContainer {
    val webMarkupContainer = WebMarkupContainer(id).apply { add(*behaviors) }
    add(webMarkupContainer)
    return webMarkupContainer
}