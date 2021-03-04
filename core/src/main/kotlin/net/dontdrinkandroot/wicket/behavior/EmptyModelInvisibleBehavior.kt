package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior

/**
 * Sets the component to invisible if its model or the modelobject is null or it is an empty string or an empty collection.
 */
class EmptyModelInvisibleBehavior : Behavior() {

    override fun onConfigure(component: Component) {
        super.onConfigure(component)
        val modelObject = component.defaultModel?.getObject()
        component.isVisible = when {
            null == modelObject -> false
            modelObject is String && modelObject.isEmpty() -> false
            modelObject is Collection<*> && modelObject.isEmpty() -> false
            else -> true
        }
    }
}

fun invisibleOnEmptyModel() = EmptyModelInvisibleBehavior()