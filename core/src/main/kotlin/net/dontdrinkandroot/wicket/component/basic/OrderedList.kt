package net.dontdrinkandroot.wicket.component.basic

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.model.IModel

open class OrderedList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    createItemComponentHandler: AbstractList<T>.(id: String, model: IModel<T>) -> Component
) : AbstractList<T>(id, model, behaviors, createItemComponentHandler) {

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "ol"
        super.onComponentTag(tag)
    }
}