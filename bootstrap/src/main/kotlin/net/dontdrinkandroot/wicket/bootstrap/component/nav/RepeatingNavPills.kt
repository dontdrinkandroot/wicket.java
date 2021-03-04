package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavPillsBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemView
import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class RepeatingNavPills<T>(
    id: String,
    model: IModel<T>? = null,
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null),
    vararg behaviors: Behavior
) : AbstractRepeatingNav<T>(id, model, *behaviors) {

    init {
        this.add(NavPillsBehavior(itemAlignmentModel))
    }
}

fun <T> repeatingNavPills(
    id: String,
    model: IModel<T>? = null,
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null),
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingNavPills<T>(id, model, itemAlignmentModel, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}

fun repeatingNavPills(
    id: String,
    itemAlignmentModel: IModel<NavItemAlignment> = Model(null),
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingNavPills<Void>(id, null, itemAlignmentModel, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}