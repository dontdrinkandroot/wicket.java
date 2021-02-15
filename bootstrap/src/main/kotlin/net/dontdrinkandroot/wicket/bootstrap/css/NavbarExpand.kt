package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class NavbarExpand(override val classString: String) : CssClass {
    DEFAULT("navbar-expand"),
    SM("navbar-expand-sm"),
    MD("navbar-expand-md"),
    LG("navbar-expand-lg"),
    XL("navbar-expand-xl");
}