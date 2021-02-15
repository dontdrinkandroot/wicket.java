package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class AlertStyle(override val classString: String) : CssClass {
    PRIMARY("alert-primary"),
    SECONDARY("alert-secondary"),
    SUCCESS("alert-success"),
    DANGER("alert-danger"),
    WARNING("alert-warning"),
    INFO("alert-info"),
    LIGHT("alert-light"),
    DARK("alert-dark");
}