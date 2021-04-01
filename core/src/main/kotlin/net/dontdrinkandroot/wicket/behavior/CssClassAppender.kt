package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.model.CssClassClassStringModel
import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.AttributeAppender
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * Appends a <tt>class</tt> attribute to an element. Can be a String, A [CssClass] or a model of a [CssClass].
 */
open class CssClassAppender : AttributeAppender {

    constructor(classToAdd: String?) : super("class", Model(classToAdd), " ")
    constructor(cssClass: CssClass) : super("class", Model(cssClass.classString), " ")
    constructor(cssClassModel: IModel<out CssClass?>) : super("class", CssClassClassStringModel(cssClassModel), " ")
}

fun cssClass(cssClassModel: IModel<out CssClass?>) = CssClassAppender(cssClassModel)

fun cssClass(cssClass: CssClass) = CssClassAppender(cssClass)

fun cssClass(cssClass: String) = CssClassAppender(cssClass)

fun MarkupContainer.addCssClass(cssClass: CssClass) {
    add(CssClassAppender(cssClass))
}

fun MarkupContainer.addCssClass(cssClass: String) {
    add(CssClassAppender(cssClass))
}

fun cssClasses(vararg cssClasses: CssClass) = CompositeBehavior(cssClasses.map { CssClassAppender(it) }.toMutableList())