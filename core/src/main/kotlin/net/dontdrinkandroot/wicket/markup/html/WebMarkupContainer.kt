package net.dontdrinkandroot.wicket.markup.html

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.GenericWebMarkupContainer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.IModel

fun webMarkupContainer(
    id: String,
    vararg behaviors: Behavior,
) = WebMarkupContainer(id).apply { behaviors.forEach { add(it) } }

fun <T> webMarkupContainer(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior,
) = GenericWebMarkupContainer<T>(id, model).apply { behaviors.forEach { add(it) } }
