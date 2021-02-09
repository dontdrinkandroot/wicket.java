package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.IModel

class PanelBehavior constructor(private val styleModel: IModel<PanelStyle> = PanelStyle.DEFAULT.model()) :
    CompositeBehavior(CssClassAppender(BootstrapCssClass.PANEL)) {

    init {
        addBehavior(CssClassAppender(this.styleModel))
    }
}