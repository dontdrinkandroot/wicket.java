package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag

/**
 * Adds a "for" attribute that will reference the id of the given targetComponent. Useful for Form Component Labels.
 */
class ForComponentIdBehavior(private val targetComponent: Component) : Behavior()
{
    override fun onComponentTag(component: Component, tag: ComponentTag)
    {
        super.onComponentTag(component, tag)
        tag.put("for", targetComponent.markupId)
    }
}