package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.AttributeModifier
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * Sets the <tt>title</tt> attribute of an element.
 */
class TitleModifier : AttributeModifier
{
    constructor(replaceModel: IModel<*>?) : super("title", replaceModel)
    constructor(titleString: String) : super("title", Model<String>(titleString))
}