package net.dontdrinkandroot.wicket.css

import java.io.Serializable

/**
 * Base interface for classes that carry CSS attributes. This can be very handy if encapsulated in Enums so one can
 * build refactoring safe CSS bindings. Mostly used in [net.dontdrinkandroot.wicket.behavior.CssClassAppender]
 * behavior.
 */
interface CssClass : Serializable {

    val classString: String
}