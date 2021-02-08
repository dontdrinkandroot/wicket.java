package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.kModel

class PanelBehavior constructor(private val styleModel: KModel<PanelStyle> = PanelStyle.DEFAULT.kModel()) :
    CompositeBehavior(CssClassAppender(BootstrapCssClass.PANEL)) {

    init {
        addBehavior(CssClassAppender(this.styleModel))
    }

    fun getStyle(): PanelStyle = styleModel.getValue()

    fun setStyle(style: PanelStyle) = styleModel.setValue(style)
}