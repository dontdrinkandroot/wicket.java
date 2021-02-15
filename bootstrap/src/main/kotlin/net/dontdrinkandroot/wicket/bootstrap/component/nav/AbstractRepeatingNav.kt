package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemContainer
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

open class AbstractRepeatingNav<T>(id: String, model: IModel<T>? = null) : GenericPanel<T>(id, model), ItemContainer {

    override val itemClass: CssClass
        get() = BootstrapCssClass.NAV_ITEM

    override val linkClass: CssClass
        get() = BootstrapCssClass.NAV_LINK

    override fun onInitialize() {
        super.onInitialize()
        val itemView = RepeatingView("item")
        populateItems(itemView)
        this.add(itemView)
    }

    protected open fun populateItems(itemView: RepeatingView) {
        /* Hook */
    }
}