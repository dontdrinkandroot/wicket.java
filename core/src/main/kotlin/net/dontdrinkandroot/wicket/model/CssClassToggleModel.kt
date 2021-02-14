package net.dontdrinkandroot.wicket.model

import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.model.IModel

open class CssClassToggleModel(
    private var activeClass: CssClass,
    private val toggleModel: IModel<Boolean> = true.model(),
    private var inactiveClass: CssClass? = null
) : IModel<CssClass> {

    override fun getObject(): CssClass? = when {
        toggleModel.getObject() -> activeClass
        else -> inactiveClass
    }

    override fun detach() {
        toggleModel.detach()
    }
}