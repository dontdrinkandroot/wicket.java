package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.nav.AbstractRepeatingNav
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.repeater.RepeatingView
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

inline fun <T> repeatingNavbarNav(
    id: String,
    model: IModel<T>? = null,
    vararg behaviors: Behavior,
    crossinline populateItemsHandler: RepeatingNavbarNav<T>.(repeatingView: RepeatingView) -> Any?
) = object : RepeatingNavbarNav<T>(id, model, *behaviors) {
    override fun populateItems(repeatingView: RepeatingView) {
        populateItemsHandler(repeatingView)
    }
}

inline fun repeatingNavbarNav(
    id: String,
    vararg behaviors: Behavior,
    crossinline populateItemsHandler: RepeatingNavbarNav<Void>.(repeatingView: RepeatingView) -> Any?
) = object : RepeatingNavbarNav<Void>(id, null, *behaviors) {
    override fun populateItems(repeatingView: RepeatingView) {
        populateItemsHandler(repeatingView)
    }
}