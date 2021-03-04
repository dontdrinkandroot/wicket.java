package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemContainer
import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemView
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

abstract class AbstractRepeatingNav<T>(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior
) : GenericPanel<T>(id, model), ItemContainer {

    init {
        add(*behaviors)
    }

    override val itemClass: CssClass
        get() = BootstrapCssClass.NAV_ITEM

    override val linkClass: CssClass
        get() = BootstrapCssClass.NAV_LINK

    override fun onInitialize() {
        super.onInitialize()
        val itemView = ItemView("item")
        populateItems(itemView)
        this.add(itemView)
    }

    abstract fun populateItems(itemView: ItemView)
}