package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.NavStyle
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.IModel

class NavPillsBehavior(
    justifiedModel: IModel<Boolean> = false.model(),
    stackedModel: IModel<Boolean> = false.model()
) : CompositeBehavior(
    CssClassAppender(BootstrapCssClass.NAV),
    CssClassAppender(NavStyle.NAV_PILLS),
    CssClassAppender(CssClassToggleModel(BootstrapCssClass.NAV_JUSTIFIED, justifiedModel)),
    CssClassAppender(CssClassToggleModel(BootstrapCssClass.NAV_STACKED, stackedModel))
)