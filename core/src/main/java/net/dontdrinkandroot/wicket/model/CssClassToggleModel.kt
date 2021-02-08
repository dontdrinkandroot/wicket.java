package net.dontdrinkandroot.wicket.model

import net.dontdrinkandroot.wicket.css.CssClass

open class CssClassToggleModel : KModel<CssClass?> {

    private var toggleModel: KModel<Boolean>
    private var activeClass: CssClass
    private var inactiveClass: CssClass? = null

    constructor(activeClass: CssClass) {
        toggleModel = true.kModel()
        this.activeClass = activeClass
    }

    constructor(toggleModel: KModel<Boolean>, activeClass: CssClass) {
        this.toggleModel = toggleModel
        this.activeClass = activeClass
    }

    constructor(toggleModel: KModel<Boolean>, activeClass: CssClass, inactiveClass: CssClass?) {
        this.toggleModel = toggleModel
        this.activeClass = activeClass
        this.inactiveClass = inactiveClass
    }

    override fun getValue(): CssClass? = when {
        active -> activeClass
        else -> inactiveClass
    }

    protected open val active: Boolean
        get() = toggleModel.getValue()

    override fun detach() {
        toggleModel.detach()
    }
}