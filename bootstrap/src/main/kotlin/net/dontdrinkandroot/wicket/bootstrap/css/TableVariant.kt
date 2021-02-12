package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class TableVariant(override val classString: String) : CssClass {
    PRIMARY("table-primary"),
    SECONDARY("table-secondary"),
    SUCCESS("table-success"),
    DANGER("table-danger"),
    WARNING("table-warning"),
    INFO("table-info"),
    LIGHT("table-light"),
    DARk("table-dark")
}