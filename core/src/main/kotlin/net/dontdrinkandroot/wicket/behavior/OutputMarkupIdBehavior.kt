package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior

class OutputMarkupIdBehavior : Behavior() {

    override fun bind(component: Component) {
        component.outputMarkupId = true
    }

    override fun isTemporary(component: Component) = true
}

fun outputMarkupId() = OutputMarkupIdBehavior()