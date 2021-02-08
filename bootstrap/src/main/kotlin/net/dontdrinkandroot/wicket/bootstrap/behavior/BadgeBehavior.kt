package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.kModel

class BadgeBehavior constructor(badgeStyleModel: KModel<BadgeStyle> = BadgeStyle.SECONDARY.kModel()) :
    CompositeBehavior(CssClassAppender(BootstrapCssClass.BADGE), CssClassAppender(badgeStyleModel)) {

    constructor(badgeStyle: BadgeStyle) : this(badgeStyle.kModel())
}