package net.dontdrinkandroot.wicket.markup.html

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.GenericWebMarkupContainer
import org.apache.wicket.model.IModel

open class WebMarkupContainer<T>(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
) : GenericWebMarkupContainer<T>(id, model) {

    init {
        behaviors.forEach { this.add(it) }
    }
}
