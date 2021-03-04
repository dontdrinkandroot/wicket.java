package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemView
import net.dontdrinkandroot.wicket.bootstrap.component.nav.AbstractRepeatingNav
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.model.IModel

abstract class RepeatingNavbarNav<T>(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior
) : AbstractRepeatingNav<T>(id, model, *behaviors) {

    init {
        add(CssClassAppender(BootstrapCssClass.NAVBAR_NAV))
        add(*behaviors)
    }

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "ul"
        super.onComponentTag(tag)
    }
}

fun <T> repeatingNavbarNav(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingNavbarNav<T>(id, model, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}

fun repeatingNavbarNav(
    id: String,
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingNavbarNav<Void>(id, null, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}

fun NavbarCollapseView.navbarNav(
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) {
    add(object : RepeatingNavbarNav<Void>(newChildId(), null, *behaviors) {
        override fun populateItems(itemView: ItemView) {
            populateItemsHandler(itemView)
        }
    })
}