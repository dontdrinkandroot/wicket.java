package net.dontdrinkandroot.wicket.component.basic

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.model.IModel

abstract class UnorderedList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    behaviors: Collection<Behavior> = emptyList(),
) : AbstractList<T>(id, model, behaviors) {

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "ul"
        super.onComponentTag(tag)
    }
}