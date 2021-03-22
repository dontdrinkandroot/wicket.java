package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.css.DropdownAlignment
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * [DropdownItem] that is populated via a [RepeatingView].
 */
abstract class RepeatingDropdownItem<T>(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    private val dropdownAlignment: IModel<DropdownAlignment?> = Model(null),
    vararg linkBehaviors: Behavior,
) : DropdownItem<T>(id, model, labelModel, *linkBehaviors) {

    override fun createDropdownMenu(id: String) = object : DropdownMenu(id, dropdownAlignment) {
        override fun populateItems(itemView: ItemView) {
            this@RepeatingDropdownItem.populateItems(itemView)
        }
    }

    abstract fun populateItems(itemView: ItemView)
}

fun <T> repeatingDropdownItem(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    dropdownAlignment: IModel<DropdownAlignment?> = Model(null),
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingDropdownItem<T>(id, model, labelModel, dropdownAlignment, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}

fun repeatingDropdownItem(
    id: String,
    labelModel: IModel<String>,
    dropdownAlignment: IModel<DropdownAlignment?> = Model(null),
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingDropdownItem<Void>(id, null, labelModel, dropdownAlignment, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}