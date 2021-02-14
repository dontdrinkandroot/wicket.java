package net.dontdrinkandroot.wicket.bootstrap.css.grid

import net.dontdrinkandroot.wicket.css.CssClass

interface ColumnSize : CssClass {

    val inverseColumnOffset: ColumnOffset?
    val inverseColumnSize: ColumnSize?
}