package net.dontdrinkandroot.wicket.model

import net.dontdrinkandroot.wicket.css.CssClass

open class CssClassToggleModel(
    private var activeClass: CssClass,
    private val toggleModel: KModel<Boolean> = true.kModel(),
    private var inactiveClass: CssClass? = null
) : KModel<CssClass?> {

    override fun getValue(): CssClass? = when {
        toggleModel.getValue() -> activeClass
        else -> inactiveClass
    }

    override fun detach() {
        toggleModel.detach()
    }
}