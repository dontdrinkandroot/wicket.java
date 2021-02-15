package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class BackgroundColor(override val classString: String) : CssClass {
    PRIMARY("bg-primary"),
    SECONDARY("bg-secondary"),
    SUCCESS("bg-success"),
    DANGER("bg-danger"),
    WARNING("bg-warning"),
    INFO("bg-info"),
    LIGHT("bg-light"),
    DARK("bg-dark"),
    WHITE("bg-white");
}