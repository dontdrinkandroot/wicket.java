package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class TextColor(override val classString: String) : CssClass {
    PRIMARY("text-primary"),
    SECONDARY("text-secondary"),
    SUCCESS("text-success"),
    DANGER("text-danger"),
    WARNING("text-warning"),
    INFO("text-info"),
    LIGHT("text-light"),
    DARK("text-dark"),
    MUTED("text-muted"),
    WHITE("text-white");
}