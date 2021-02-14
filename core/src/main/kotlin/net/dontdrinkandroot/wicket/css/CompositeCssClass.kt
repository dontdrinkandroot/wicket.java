package net.dontdrinkandroot.wicket.css

import java.util.stream.Collectors

/**
 * A [CssClass] that is composed of multiple CssClasses.
 */
class CompositeCssClass : CssClass {

    private var cssClasses: List<CssClass>

    constructor(vararg cssClasses: CssClass?) {
        this.cssClasses = listOfNotNull(*cssClasses)
    }

    constructor(vararg cssClassStrings: String?) {
        cssClasses = listOfNotNull(*cssClassStrings).map { StringCssClass(it) }
    }

    override val classString: String
        get() = cssClasses.stream().map(CssClass::classString).collect(Collectors.joining(" "))
}