package net.dontdrinkandroot.wicket.bootstrap.component.breadcrumb

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemContainer
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.RepeatingList
import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.model.IModel

abstract class RepeatingBreadcrumb<T>(id: String?, model: IModel<T>? = null) :
    RepeatingList<T>(id, model), ItemContainer {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.BREADCRUMB))
    }

    override val itemClass: CssClass
        get() = BootstrapCssClass.BREADCRUMB_ITEM
}