package net.dontdrinkandroot.wicket.css

import java.io.Serializable

/**
 * A [CssClass] that is represented by a String.
 */
class StringCssClass(override val classString: String) : CssClass, Serializable