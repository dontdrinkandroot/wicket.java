package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class AlertBehavior(alertStyleModel: IModel<AlertStyle>) :
    CompositeBehavior(CssClassAppender(BootstrapCssClass.ALERT), CssClassAppender(alertStyleModel)) {

    constructor(alertStyle: AlertStyle) : this(Model(alertStyle))
}