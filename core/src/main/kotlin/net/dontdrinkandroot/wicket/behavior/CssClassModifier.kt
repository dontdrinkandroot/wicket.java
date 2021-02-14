package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.model.CssClassClassStringModel
import org.apache.wicket.AttributeModifier
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * Replaces the <tt>class</tt> attribute of an element. Can be a String, A [CssClass] or a model of a [CssClass].
 */
class CssClassModifier : AttributeModifier {

    constructor(classToAdd: String?) : super("class", Model(classToAdd))
    constructor(cssClass: CssClass) : super("class", Model(cssClass.classString))
    constructor(cssClassModel: IModel<CssClass>) : super("class", CssClassClassStringModel(cssClassModel))
}