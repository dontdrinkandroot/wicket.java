package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.NavStyle
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.kModel

class NavTabsBehavior(justifiedModel: KModel<Boolean> = false.kModel()) :
    CompositeBehavior(
        CssClassAppender(BootstrapCssClass.NAV),
        CssClassAppender(NavStyle.NAV_TABS),
        CssClassAppender(CssClassToggleModel(BootstrapCssClass.NAV_JUSTIFIED, justifiedModel))
    )