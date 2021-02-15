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
    labelModel: IModel<String>
) : DropdownItem<T>(id, model, labelModel) {

    override fun createDropdownMenu(id: String): DropdownMenu {
        return object : DropdownMenu(id) {
            override fun populateItems(itemView: RepeatingView) {
                this@RepeatingDropdownItem.populateItems(itemView)
            }
        }
    }

    protected abstract fun populateItems(itemView: RepeatingView)
}