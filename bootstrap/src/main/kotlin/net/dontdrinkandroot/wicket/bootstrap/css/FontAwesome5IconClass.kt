package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class FontAwesome5IconClass(override val classString: String) : CssClass {
    ANGLE_DOUBLE_LEFT("fa-angle-double-left"),
    ANGLE_LEFT("fa-angle-left"),
    ANGLE_RIGHT("fa-angle-right"),
    ANGLE_DOUBLE_RIGHT("fa-angle-double-right"),
    ARROWS_ALT_H("fa-arrows-alt-h"),
    EDIT("fa-edit"),
    ELLIPSIS_V("fa-ellipsis-v"),
    FILE("fa-file"),
    PAUSE("fa-pause"),
    PLUS("fa-plus"),
    UNDO("fa-undo");

    fun createIcon(style: FontAwesome5Icon.Style = FontAwesome5Icon.Style.SOLID): FontAwesome5Icon =
        FontAwesome5Icon(this, style)
}