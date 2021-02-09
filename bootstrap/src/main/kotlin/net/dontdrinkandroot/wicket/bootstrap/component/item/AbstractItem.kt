package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

/**
 * Base class for most items. Items can be used in Navs or DropDown menus. Items support an active state which can
 * be changed by overriding the [AbstractItem.active] method.
 *
 * @param <T> Type of the item.
 */
open class AbstractItem<T>(id: String, model: IModel<T>? = null) : GenericPanel<T>(id, model) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(CssClassToggleModel(BootstrapCssClass.ACTIVE, { this@AbstractItem.active })))
        this.add(CssClassAppender(IModel<CssClass> {
            var parent = parent
            if (parent is ItemContainer) {
                (parent as ItemContainer).itemClass
            }
            parent = parent.parent
            if (parent is ItemContainer) {
                (parent as ItemContainer).itemClass
            }
            null
        }))
    }

    protected open val active: Boolean
        get() = false
}