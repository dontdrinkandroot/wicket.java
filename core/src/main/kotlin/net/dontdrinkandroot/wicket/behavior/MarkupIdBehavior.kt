package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior

class MarkupIdBehavior(private val id: String) : Behavior() {

    override fun bind(component: Component) {
        component.markupId = id
    }

    override fun isTemporary(component: Component) = true
}

fun markupId(id: String) = MarkupIdBehavior(id)