package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

/**
 * [DropdownItem] that is populated via a [RepeatingView].
 */
abstract class RepeatingDropdownItem<T>(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    vararg linkBehaviors: Behavior,
) : DropdownItem<T>(id, model, labelModel, *linkBehaviors) {

    override fun createDropdownMenu(id: String) = object : DropdownMenu(id) {
        override fun populateItems(itemView: ItemView) {
            this@RepeatingDropdownItem.populateItems(itemView)
        }
    }

    abstract fun populateItems(itemView: ItemView)
}

fun <T> createRepeatingDropdownItem(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingDropdownItem<T>(id, model, labelModel, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}

fun createRepeatingDropdownItem(
    id: String,
    labelModel: IModel<String>,
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingDropdownItem<Void>(id, null, labelModel, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}