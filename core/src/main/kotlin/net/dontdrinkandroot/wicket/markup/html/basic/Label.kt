package net.dontdrinkandroot.wicket.markup.html.basic

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel

class Label<T>(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior
) : Label(id, model) {

    init {
        behaviors.forEach { this.add(it) }
    }
}