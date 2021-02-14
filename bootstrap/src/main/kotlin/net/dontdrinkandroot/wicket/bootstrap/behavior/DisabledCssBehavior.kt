package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag

/**
 * Adds [BootstrapCssClass.DISABLED] to the class attribute of components that are not enabled
 * in hierarchy.
 */
class DisabledCssBehavior : Behavior() {

    override fun onComponentTag(component: Component, tag: ComponentTag) {
        super.onComponentTag(component, tag)
        if (!component.isEnabledInHierarchy) {
            tag.append("class", BootstrapCssClass.DISABLED.classString, " ")
        }
    }
}