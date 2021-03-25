package net.dontdrinkandroot.wicket.component.basic

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel

class SubmitButtonLabel(id: String, model: IModel<*>, vararg behaviors: Behavior) : Label(id, model) {

    init {
        add(*behaviors)
    }

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "button"
        tag.put("type", "submit")
        super.onComponentTag(tag)
    }
}