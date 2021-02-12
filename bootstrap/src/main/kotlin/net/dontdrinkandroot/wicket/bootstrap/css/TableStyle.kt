package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class TableStyle(override val classString: String) : CssClass {
    ACTIVE("table-active"),
    BORDERED("table-bordered"),
    BORDERLESS("table-borderless"),
    SMALL("table-sm"),
    DARK("table-dark"),
    HOVER("table-hover"),
    STRIPED("table-striped");
}