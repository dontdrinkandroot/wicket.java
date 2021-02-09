package net.dontdrinkandroot.wicket.model

import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.model.IModel

class CssClassClassStringModel : AbstractChainedModel<CssClass?, String?> {

    var active: Boolean = true

    constructor(parent: IModel<out CssClass?>) : super(parent)

    constructor(cssClass: CssClass) : super(cssClass.model())

    override fun getValue(parentValue: CssClass?): String? =
        if (parentValue == null || !active) null else parentValue.classString

}