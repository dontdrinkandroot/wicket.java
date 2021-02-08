package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.model.CssClassClassStringModel
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.StringModel
import org.apache.wicket.AttributeModifier

/**
 * Replaces the <tt>class</tt> attribute of an element. Can be a String, A [CssClass] or a model of a [CssClass].
 */
class CssClassModifier : AttributeModifier
{
    constructor(classToAdd: String?) : super("class", StringModel(classToAdd))
    constructor(cssClass: CssClass) : super("class", StringModel(cssClass.classString))
    constructor(cssClassModel: KModel<CssClass>) : super("class", CssClassClassStringModel(cssClassModel))
}