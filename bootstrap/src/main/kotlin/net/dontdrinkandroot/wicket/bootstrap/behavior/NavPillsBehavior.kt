package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.NavStyle
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import net.dontdrinkandroot.wicket.model.kModel

class NavPillsBehavior :
    CompositeBehavior(CssClassAppender(BootstrapCssClass.NAV), CssClassAppender(NavStyle.NAV_PILLS)) {

    private val justifiedModel = false.kModel()
    private val stackedModel = false.kModel()

    init {
        addBehavior(
            CssClassAppender(
                CssClassToggleModel(justifiedModel, BootstrapCssClass.NAV_JUSTIFIED)
            )
        )
        addBehavior(
            CssClassAppender(
                CssClassToggleModel(stackedModel, BootstrapCssClass.NAV_STACKED)
            )
        )
    }

    fun setJustified(justified: Boolean) {
        justifiedModel.setObject(justified)
    }

    fun setStacked(stacked: Boolean) {
        stackedModel.setObject(stacked)
    }
}