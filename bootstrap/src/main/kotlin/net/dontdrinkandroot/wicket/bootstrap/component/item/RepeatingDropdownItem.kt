package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.kmodel.kModel
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

fun <T> repeatingDropdownItem(
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

fun repeatingDropdownItem(
    id: String,
    labelModel: IModel<String>,
    vararg behaviors: Behavior,
    populateItemsHandler: ItemView.() -> Any?
) = object : RepeatingDropdownItem<Void>(id, null, labelModel, *behaviors) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView)
    }
}

fun ItemView.dropdown(label: String, vararg linkBehaviors: Behavior, populateItemsHandler: ItemView.() -> Any?) {
    this.add(object : RepeatingDropdownItem<Void>(this.newChildId(), null, kModel(label), *linkBehaviors) {
        override fun populateItems(itemView: ItemView) {
            populateItemsHandler(itemView)
        }
    })
}