package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

/**
 * [DropdownItem] that is populated via a [RepeatingView].
 */
abstract class RepeatingDropdownItem<T>(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
) : DropdownItem<T>(id, model, labelModel) {

    override fun createDropdownMenu(id: String) = object : DropdownMenu(id) {
        override fun populateItems(itemView: RepeatingView) {
            this@RepeatingDropdownItem.populateItems(itemView)
        }
    }

    abstract fun populateItems(itemView: RepeatingView)
}

fun <T> repeatingDropdownItem(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    populateItemsHandler: RepeatingDropdownItem<T>.(itemView: RepeatingView) -> Any?
) = object : RepeatingDropdownItem<T>(id, model, labelModel) {
    override fun populateItems(itemView: RepeatingView) {
        populateItemsHandler(itemView)
    }
}

fun repeatingDropdownItem(
    id: String,
    labelModel: IModel<String>,
    populateItemsHandler: RepeatingDropdownItem<Void>.(itemView: RepeatingView) -> Any?
) = object : RepeatingDropdownItem<Void>(id, null, labelModel) {
    override fun populateItems(itemView: RepeatingView) {
        populateItemsHandler(itemView)
    }
}