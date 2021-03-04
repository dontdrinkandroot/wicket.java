package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.markup.repeater.RepeatingView

interface ItemContainer {

    val itemClass: CssClass?
        get() = null

    val linkClass: CssClass?
        get() = null
}

class ItemView(id: String) : RepeatingView(id)