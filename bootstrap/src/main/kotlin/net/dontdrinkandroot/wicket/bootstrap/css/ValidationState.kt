package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class ValidationState(override val classString: String) : CssClass {
    VALID("is-valid"),
    INVALID("is-invalid");
}