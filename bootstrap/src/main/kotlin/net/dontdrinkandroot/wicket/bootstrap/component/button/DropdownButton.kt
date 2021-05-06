package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.behavior.addCssClass
import net.dontdrinkandroot.wicket.bootstrap.behavior.dropdownToggle
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemView
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.DropdownAlignment
import net.dontdrinkandroot.wicket.markup.html.basic.label
import org.apache.wicket.IGenericComponent
import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 */
abstract class DropdownButton<T>(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String>? = null,
    dropdownAlignmentModel: IModel<DropdownAlignment?> = Model(null),
    vararg toggleBehaviors: Behavior
) : GenericPanel<T>(id, model) {

    val toggle: Label = label("toggle", label, dropdownToggle()).apply { add(*toggleBehaviors) }

    val menu: DropdownMenu = object : DropdownMenu("menu", dropdownAlignmentModel) {
        override fun populateItems(itemView: ItemView) {
            this@DropdownButton.populateItems(itemView)
        }
    }

    override fun onInitialize() {
        super.onInitialize()
        addCssClass(BootstrapCssClass.DROPDOWN)
        add(toggle)
        add(menu)
    }

    protected abstract fun populateItems(itemView: ItemView)
}

inline fun <T> MarkupContainer.addDropdownButton(
    id: String,
    model: IModel<T>,
    vararg toggleBehaviors: Behavior,
    crossinline populateItemsHandler: ItemView.(DropdownButton<T>) -> Unit
): DropdownButton<T> {
    val dropdownButton = object : DropdownButton<T>(
        id = id,
        model = model,
        toggleBehaviors = toggleBehaviors
    ) {
        override fun populateItems(itemView: ItemView) {
            populateItemsHandler(itemView, this)
        }
    }
    add(dropdownButton)
    return dropdownButton
}

inline fun <T> dropdownButton(
    id: String,
    model: IModel<T>,
    dropdownAlignment: DropdownAlignment,
    vararg toggleBehaviors: Behavior,
    crossinline populateItemsHandler: ItemView.(DropdownButton<T>) -> Unit
): DropdownButton<T> = object : DropdownButton<T>(
    id = id,
    model = model,
    dropdownAlignmentModel = Model(dropdownAlignment),
    toggleBehaviors = toggleBehaviors
) {
    override fun populateItems(itemView: ItemView) {
        populateItemsHandler(itemView, this)
    }
}

inline fun <T> MarkupContainer.addDropdownButton(
    id: String,
    model: IModel<T>,
    dropdownAlignment: DropdownAlignment,
    vararg toggleBehaviors: Behavior,
    crossinline populateItemsHandler: ItemView.(DropdownButton<T>) -> Unit
): DropdownButton<T> {
    val dropdownButton =
        dropdownButton(id, model, dropdownAlignment, toggleBehaviors = toggleBehaviors, populateItemsHandler)
    add(dropdownButton)
    return dropdownButton
}

inline fun <T, C> C.addDropdownButton(
    id: String,
    dropdownAlignment: DropdownAlignment,
    vararg toggleBehaviors: Behavior,
    crossinline populateItemsHandler: ItemView.(DropdownButton<T>) -> Unit
): DropdownButton<T> where C : MarkupContainer, C : IGenericComponent<T, C> {
    val dropdownButton =
        dropdownButton(id, model, dropdownAlignment, toggleBehaviors = toggleBehaviors, populateItemsHandler)
    add(dropdownButton)
    return dropdownButton
}
