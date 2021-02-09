package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.IModel

class AlertBehavior(alertStyleModel: IModel<AlertStyle>) :
    CompositeBehavior(CssClassAppender(BootstrapCssClass.ALERT), CssClassAppender(alertStyleModel)) {

    constructor(alertStyle: AlertStyle) : this(alertStyle.model())
}