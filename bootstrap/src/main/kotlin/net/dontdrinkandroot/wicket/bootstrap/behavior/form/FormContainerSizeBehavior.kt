package net.dontdrinkandroot.wicket.bootstrap.behavior.form

import findClosestBehavior
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag

class FormContainerSizeBehavior : Behavior() {

    override fun onConfigure(component: Component) {
        super.onConfigure(component)
        val formStyleBehavior = component.findClosestBehavior(FormStyleBehavior::class)
        component.renderBodyOnly = null == formStyleBehavior || formStyleBehavior.isInline
    }

    override fun onComponentTag(component: Component, tag: ComponentTag) {
        super.onComponentTag(component, tag)
        val formStyleBehavior = component.findClosestBehavior(FormStyleBehavior::class)
        if (null != formStyleBehavior && formStyleBehavior.isHorizontal) {
            tag.append("class", formStyleBehavior.containerSize!!.classString, " ")
        }
    }
}