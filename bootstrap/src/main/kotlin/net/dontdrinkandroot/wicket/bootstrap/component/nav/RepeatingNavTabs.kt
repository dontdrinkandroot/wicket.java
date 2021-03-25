package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavTabsBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemView
import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class RepeatingNavTabs<T>(
    id: String,
    model: IModel<T>? = null,
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null),
    vararg behaviors: Behavior
) : AbstractRepeatingNav<T>(id, model, *behaviors) {

    init {
        this.add(NavTabsBehavior(itemAlignmentModel))
    }
}

inline fun <T> navTabs(
    id: String,
    model: IModel<T>? = null,
    itemAlignment: IModel<NavItemAlignment> = Model(null),
    vararg behaviors: Behavior,
    crossinline populateItemsHandler: ItemView.(repeatingNavTabs: RepeatingNavTabs<T>) -> Any?
) = object : RepeatingNavTabs<T>(id, model, itemAlignment, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView, this)
    }
}

inline fun navTabs(
    id: String,
    itemAlignment: IModel<NavItemAlignment> = Model(null),
    vararg behaviors: Behavior,
    crossinline populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingNavTabs<Void>(id, null, itemAlignment, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}

inline fun MarkupContainer.addNavTabs(
    id: String,
    itemAlignment: IModel<NavItemAlignment> = Model(null),
    vararg behaviors: Behavior,
    crossinline populateItemsHandler: ItemView.() -> Any?
): RepeatingNavTabs<Void> {
    val repeatingNavTabs = navTabs(id, itemAlignment, behaviors = behaviors, populateItemsHandler)
    add(repeatingNavTabs)
    return repeatingNavTabs
}