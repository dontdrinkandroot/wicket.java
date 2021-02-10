package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
import net.dontdrinkandroot.wicket.bootstrap.css.NavStyle
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class NavPillsBehavior(
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null)
) : CompositeBehavior(
    CssClassAppender(BootstrapCssClass.NAV),
    CssClassAppender(NavStyle.NAV_PILLS),
    CssClassAppender(itemAlignmentModel)
)