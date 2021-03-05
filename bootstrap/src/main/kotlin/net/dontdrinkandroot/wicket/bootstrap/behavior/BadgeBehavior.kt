package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class BadgeBehavior constructor(badgeStyleModel: IModel<BadgeStyle> = Model(BadgeStyle.SECONDARY)) :
    CompositeBehavior(CssClassAppender(BootstrapCssClass.BADGE), CssClassAppender(badgeStyleModel)) {

    constructor(badgeStyle: BadgeStyle) : this(Model(badgeStyle))
}