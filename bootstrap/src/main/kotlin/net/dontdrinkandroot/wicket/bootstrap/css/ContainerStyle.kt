package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

enum class ContainerStyle(override val classString: String) : CssClass {
    DEFAULT("container"),
    FLUID("container-fluid");
}