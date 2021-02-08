package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.NavStyle
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import net.dontdrinkandroot.wicket.model.kModel

class NavTabsBehavior :
    CompositeBehavior(CssClassAppender(BootstrapCssClass.NAV), CssClassAppender(NavStyle.NAV_TABS)) {

    private val justifiedModel = false.kModel()

    init {
        addBehavior(CssClassAppender(CssClassToggleModel(justifiedModel, BootstrapCssClass.NAV_JUSTIFIED)))
    }

    fun setJustified(justified: Boolean) {
        justifiedModel.setObject(justified)
    }
}