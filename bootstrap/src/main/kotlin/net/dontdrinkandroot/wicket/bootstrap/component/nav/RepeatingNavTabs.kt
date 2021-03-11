package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavTabsBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemView
import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
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

fun <T> createRepeatingNavTabs(
    id: String,
    model: IModel<T>? = null,
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null),
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.(repeatingNavTabs: RepeatingNavTabs<T>) -> Any?
) = object : RepeatingNavTabs<T>(id, model, itemAlignmentModel, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView, this)
    }
}

fun createRepeatingNavTabs(
    id: String,
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null),
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingNavTabs<Void>(id, null, itemAlignmentModel, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}