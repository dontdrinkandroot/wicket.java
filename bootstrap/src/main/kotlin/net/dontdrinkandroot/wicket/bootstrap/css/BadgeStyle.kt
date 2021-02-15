package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class BadgeStyle(override val classString: String) : CssClass {
    PRIMARY("badge-primary"),
    SECONDARY("badge-secondary"),
    SUCCESS("badge-success"),
    DANGER("badge-danger"),
    WARNING("badge-warning"),
    INFO("badge-info"),
    LIGHT("badge-light"),
    DARK("badge-dark");
}