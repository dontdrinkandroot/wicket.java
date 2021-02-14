package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.css.CssClass

interface ItemContainer {

    val itemClass: CssClass?
        get() = null

    val linkClass: CssClass?
        get() = null
}