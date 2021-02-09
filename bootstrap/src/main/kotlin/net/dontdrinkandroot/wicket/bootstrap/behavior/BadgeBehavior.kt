package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.IModel

class BadgeBehavior constructor(badgeStyleModel: IModel<BadgeStyle> = BadgeStyle.SECONDARY.model()) :
    CompositeBehavior(CssClassAppender(BootstrapCssClass.BADGE), CssClassAppender(badgeStyleModel)) {

    constructor(badgeStyle: BadgeStyle) : this(badgeStyle.model())
}