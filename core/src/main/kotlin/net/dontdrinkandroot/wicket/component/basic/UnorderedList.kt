package net.dontdrinkandroot.wicket.component.basic

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.model.IModel

abstract class UnorderedList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
) : AbstractList<T>(id, model, *behaviors) {

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "ul"
        super.onComponentTag(tag)
    }
}

inline fun <T> unorderedList(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
    crossinline createItemHandler: UnorderedList<T>.(id: String, model: IModel<T>) -> Component
) = object : UnorderedList<T>(id, model, *behaviors) {
    override fun createItem(id: String, model: IModel<T>) = createItemHandler(id, model)
}