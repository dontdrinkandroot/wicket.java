package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class PanelStyle(override val classString: String) : CssClass {
    DEFAULT("panel-default"),
    PRIMARY("panel-primary"),
    SUCCESS("panel-success"),
    INFO("panel-info"),
    WARNING("panel-warning"),
    DANGER("panel-danger");
}