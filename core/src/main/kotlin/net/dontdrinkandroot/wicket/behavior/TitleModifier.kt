package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.AttributeModifier
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * Sets the <tt>title</tt> attribute of an element.
 */
class TitleModifier : AttributeModifier {

    constructor(title: IModel<*>?) : super("title", title)
    constructor(title: String) : super("title", Model<String>(title))
}

fun title(title: String) = TitleModifier(title)

fun title(title: IModel<String>) = TitleModifier(title)