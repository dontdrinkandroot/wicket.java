package net.dontdrinkandroot.wicket.component.basic

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.model.IModel

abstract class OrderedList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
) : AbstractList<T>(id, model, *behaviors) {

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "ol"
        super.onComponentTag(tag)
    }
}

inline fun <T> orderedList(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
    crossinline createItemHandler: OrderedList<T>.(id: String, model: IModel<T>) -> Component
) = object : OrderedList<T>(id, model, *behaviors) {
    override fun createItem(id: String, model: IModel<T>) = createItemHandler(id, model)
}