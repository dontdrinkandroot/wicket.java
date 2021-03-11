package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.behavior.AttributeAppender
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * Appends the given style to the style attribute of an element.
 */
open class StyleAppender : AttributeAppender {

    constructor(style: String?) : super("style", Model(style), ";")

    constructor(styleModel: IModel<*>?) : super("style", styleModel, ";")
}