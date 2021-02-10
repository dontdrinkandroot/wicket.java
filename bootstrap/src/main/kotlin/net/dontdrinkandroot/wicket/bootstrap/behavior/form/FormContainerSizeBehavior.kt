package net.dontdrinkandroot.wicket.bootstrap.behavior.form

import net.dontdrinkandroot.wicket.util.BehaviorUtils
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag

class FormContainerSizeBehavior : Behavior() {

    override fun onConfigure(component: Component) {
        super.onConfigure(component)
        val formStyleBehavior = BehaviorUtils.findClosestBehavior(component, FormStyleBehavior::class.java)
        component.renderBodyOnly = null == formStyleBehavior || formStyleBehavior.isInline
    }

    override fun onComponentTag(component: Component, tag: ComponentTag) {
        super.onComponentTag(component, tag)
        val formStyleBehavior = BehaviorUtils.findClosestBehavior(component, FormStyleBehavior::class.java)
        if (null != formStyleBehavior && formStyleBehavior.isHorizontal) {
            tag.append("class", formStyleBehavior.containerSize.classString, " ")
        }
    }
}