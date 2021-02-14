package net.dontdrinkandroot.wicket.behavior.aria

import org.apache.wicket.behavior.AttributeAppender
import org.apache.wicket.model.IModel

class AriaAppender : AttributeAppender {
    constructor(attribute: Aria) : super(attribute.attribute, VALUELESS_ATTRIBUTE_ADD)
    constructor(attribute: Aria, value: String?) : super(attribute.attribute, value)
    constructor(attribute: Aria, value: IModel<String?>?) : super(attribute.attribute, value)
}