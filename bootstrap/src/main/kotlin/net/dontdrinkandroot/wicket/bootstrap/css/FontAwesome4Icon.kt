package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass
import java.lang.StringBuilder

class FontAwesome4Icon(
    val iconClass: FontAwesome4IconClass,
    var fixedWidth: Boolean = false,
    var spinning: Boolean = false,
    var outline: Boolean = false,
    var shape: String? = null,
    var direction: String? = null
) : CssClass {

    override val classString: String
        get() {
            val builder = StringBuilder("fa ")
            builder.append(iconClass.classString)
            if (shape != null) {
                builder.append("-")
                builder.append(shape)
            }
            if (outline) builder.append("-o")
            if (direction != null) {
                builder.append("-")
                builder.append(direction)
            }
            if (fixedWidth) builder.append(" fa-fw")
            if (spinning) builder.append(" fa-spin")
            return builder.toString()
        }
}