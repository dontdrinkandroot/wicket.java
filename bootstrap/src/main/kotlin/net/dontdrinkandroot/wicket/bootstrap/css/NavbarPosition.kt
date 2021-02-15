package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class NavbarPosition(override val classString: String) : CssClass {
    FIXED_TOP("fixed-top"),
    FIXED_BOTTOM("fixed-bottom"),
    STATIC_TOP("sticky-top");
}