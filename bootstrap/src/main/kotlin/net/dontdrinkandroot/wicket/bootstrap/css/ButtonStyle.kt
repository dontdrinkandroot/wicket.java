package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class ButtonStyle(override val classString: String) : CssClass {
    PRIMARY("btn-primary"),
    SECONDARY("btn-secondary"),
    SUCCESS("btn-success"),
    DANGER("btn-danger"),
    WARNING("btn-warning"),
    INFO("btn-info"),
    LIGHT("btn-light"),
    DARK("btn-dark"),
    LINK("btn-link"),
    OUTLINE_PRIMARY("btn-outline-primary"),
    OUTLINE_SECONDARY("btn-outline-secondary"),
    OUTLINE_SUCCESS("btn-outline-success"),
    OUTLINE_DANGER("btn-outline-danger"),
    OUTLINE_WARNING("btn-outline-warning"),
    OUTLINE_INFO("btn-outline-info"),
    OUTLINE_LIGHT("btn-outline-light"),
    OUTLINE_DARK("btn-outline-dark");
}