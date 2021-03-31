package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropdownToggleBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.DropdownAlignment
import net.dontdrinkandroot.wicket.kmodel.model
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class DropdownItem<T>(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String>,
    vararg linkBehaviors: Behavior,
) : AbstractLinkItem<T, AbstractLink>(id, model, label, emptyArray(), *linkBehaviors) {

    protected lateinit var dropdownMenu: DropdownMenu

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.DROPDOWN))
        dropdownMenu = createDropdownMenu("dropdownMenu")
        this.add(dropdownMenu)
    }

    override fun createLink(id: String): AbstractLink {
        val link: AbstractLink = object : AbstractLink(id) {}
        link.add(DropdownToggleBehavior())
        return link
    }

    protected abstract fun createDropdownMenu(id: String): DropdownMenu
}

inline fun ItemView.addDropdown(
    label: String,
    dropdownAlignment: DropdownAlignment? = null,
    vararg linkBehaviors: Behavior,
    crossinline populateItemsHandler: ItemView.() -> Any?
): RepeatingDropdownItem<Void> {
    val repeatingDropdownItem = object :
        RepeatingDropdownItem<Void>(this.newChildId(), null, model(label), Model(dropdownAlignment), *linkBehaviors) {
        override fun populateItems(itemView: ItemView) {
            populateItemsHandler(itemView)
        }
    }
    this.add(repeatingDropdownItem)
    return repeatingDropdownItem
}

inline fun ItemView.addDropdown(
    label: String,
    vararg linkBehaviors: Behavior,
    crossinline populateItemsHandler: ItemView.() -> Any?
): RepeatingDropdownItem<Void> {
    val repeatingDropdownItem = object :
        RepeatingDropdownItem<Void>(this.newChildId(), null, model(label), Model(null), *linkBehaviors) {
        override fun populateItems(itemView: ItemView) {
            populateItemsHandler(itemView)
        }
    }
    this.add(repeatingDropdownItem)
    return repeatingDropdownItem
}

inline fun ItemView.addDropdown(
    label: IModel<String>,
    dropdownAlignment: DropdownAlignment? = null,
    vararg linkBehaviors: Behavior,
    crossinline populateItemsHandler: ItemView.() -> Any?
): RepeatingDropdownItem<Void> {
    val repeatingDropdownItem = object :
        RepeatingDropdownItem<Void>(this.newChildId(), null, label, Model(dropdownAlignment), *linkBehaviors) {
        override fun populateItems(itemView: ItemView) {
            populateItemsHandler(itemView)
        }
    }
    this.add(repeatingDropdownItem)
    return repeatingDropdownItem
}