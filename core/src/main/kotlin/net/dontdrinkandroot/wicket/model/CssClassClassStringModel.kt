package net.dontdrinkandroot.wicket.model

import net.dontdrinkandroot.wicket.css.CssClass

class CssClassClassStringModel : AbstractChainedModel<CssClass?, String?> {

    var active: Boolean = true

    constructor(parent: KModel<out CssClass?>) : super(parent)

    constructor(cssClass: CssClass) : super(cssClass.kModel())

    override fun getValue(parentValue: CssClass?): String? =
        if (parentValue == null || !active) null else parentValue.classString

}