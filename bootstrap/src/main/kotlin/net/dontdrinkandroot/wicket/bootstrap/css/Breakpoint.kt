package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class Breakpoint(override val classString: String) : CssClass {
    SMALL("sm"),
    MEDIUM("md"),
    LARGE("lg"),
    EXTRA_LARGE("xl"),
    EXTRA_EXTRA_LARGE("xxl");
}