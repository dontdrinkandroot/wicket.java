package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

class FontAwesome5Icon(
    private val iconClass: FontAwesome5IconClass,
    val style: Style = Style.SOLID,
    var fixedWidth: Boolean = false,
    var spin: Boolean = false,
    var pulse: Boolean = false
) : CssClass {

    override val classString: String
        get() {
            val builder = StringBuilder(style.prefix)
            builder.append(" ")
            builder.append(iconClass.classString)
            if (fixedWidth) builder.append(" fa-fw")
            if (spin) builder.append(" fa-spin")
            if (pulse) builder.append(" fa-pulse")
            return builder.toString()
        }

    enum class Style(val prefix: String) {
        SOLID("fas"),
        REGULAR("far"),
        LIHT("fal"),
        DUOTONE("fad"),
    }
}