package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class TextTransformation(override val classString: String) : CssClass {
    LOWERCASE("text-lowercase"),
    UPPERCASE("text-uppercase"),
    CAPITALIZE("text-capitalize");
}