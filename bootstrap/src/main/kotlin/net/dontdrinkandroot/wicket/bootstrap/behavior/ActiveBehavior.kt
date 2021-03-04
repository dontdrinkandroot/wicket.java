package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.model.CssClassToggleModel

fun active(activeHandler: () -> Boolean) =
    CssClassAppender(CssClassToggleModel(BootstrapCssClass.ACTIVE, activeHandler))