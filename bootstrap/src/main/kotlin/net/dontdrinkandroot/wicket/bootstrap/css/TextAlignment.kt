package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class TextAlignment(override val classString: String) : CssClass {
    START("text-start"),
    CENTER("text-center"),
    END("text-end"),
    JUSTIFY("text-justify"),
    NOWRAP("text-nowrap");
}