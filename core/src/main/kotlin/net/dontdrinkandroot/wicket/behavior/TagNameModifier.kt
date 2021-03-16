package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag

/**
 * Changes the component tag name. Note that as this is a behavior this is done after the
 * [Component.onComponentTag] execution.
 */
class TagNameModifier(private val tagName: String) : Behavior() {

    override fun onComponentTag(component: Component, tag: ComponentTag) {
        tag.name = tagName
    }
}

fun tagName(tagName: String) = TagNameModifier(tagName)

fun MarkupContainer.setTagName(tagName: String) {
    add(tagName(tagName))
}