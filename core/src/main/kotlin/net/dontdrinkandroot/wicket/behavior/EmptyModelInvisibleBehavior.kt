package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior

/**
 * Sets the component to invisible if its model or the modelobject is null or it is an empty string.
 */
class EmptyModelInvisibleBehavior : Behavior()
{
    override fun onConfigure(component: Component)
    {
        super.onConfigure(component)
        val modelObject = component.defaultModel?.getObject()
        component.isVisible = null != modelObject && (modelObject !is String || modelObject.isNotEmpty())
    }
}
