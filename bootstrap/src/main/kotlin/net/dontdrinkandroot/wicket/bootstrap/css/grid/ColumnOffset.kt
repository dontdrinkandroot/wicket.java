package net.dontdrinkandroot.wicket.bootstrap.css.grid

import net.dontdrinkandroot.wicket.css.CssClass

interface ColumnOffset : CssClass {

    val inverseColumnSize: ColumnSize
    val inverseColumnOffset: ColumnOffset
}