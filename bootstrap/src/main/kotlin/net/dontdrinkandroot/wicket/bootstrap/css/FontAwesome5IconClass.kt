package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class FontAwesome5IconClass(override val classString: String) : CssClass {
    ANGLE_DOUBLE_LEFT("fa-angle-double-left"),
    ANGLE_LEFT("fa-angle-left"),
    ANGLE_RIGHT("fa-angle-right"),
    ANGLE_DOUBLE_RIGHT("fa-angle-double-right"),
    ARROWS_ALT_H("fa-arrows-alt-h"),
    DOWNLOAD("fa-download"),
    EDIT("fa-edit"),
    ELLIPSIS_V("fa-ellipsis-v"),
    FILE("fa-file"),
    LOCK("fa-lock"),
    PAUSE("fa-pause"),
    PEN("fa-pen"),
    PLUS("fa-plus"),
    PRINT("fa-print"),
    TRASH("fa-trash"),
    UNDO("fa-undo"),
    UPLOAD("fa-upload");

    fun createIcon(
        style: FontAwesome5Icon.Style = FontAwesome5Icon.Style.SOLID,
        fixedWidth: Boolean = false
    ): FontAwesome5Icon =
        FontAwesome5Icon(this, style = style, fixedWidth = fixedWidth)
}