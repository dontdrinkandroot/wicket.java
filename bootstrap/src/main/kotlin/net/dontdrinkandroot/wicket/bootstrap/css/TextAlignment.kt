package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class TextAlignment(override val classString: String) : CssClass {
    LEFT("text-left"),
    CENTER("text-center"),
    RIGHT("text-right"),
    JUSTIFY("text-justify"),
    NOWRAP("text-nowrap");
}