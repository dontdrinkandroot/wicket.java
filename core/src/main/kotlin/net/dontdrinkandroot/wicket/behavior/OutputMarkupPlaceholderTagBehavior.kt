package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior

class OutputMarkupPlaceholderTagBehavior : Behavior() {

    override fun bind(component: Component) {
        component.outputMarkupPlaceholderTag = true
    }

    override fun isTemporary(component: Component) = true
}