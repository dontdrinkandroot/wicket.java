package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropdownToggleBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.kmodel.model
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.model.IModel

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

fun ItemView.addDropdown(label: String, vararg linkBehaviors: Behavior, populateItemsHandler: ItemView.() -> Any?) {
    this.add(object : RepeatingDropdownItem<Void>(this.newChildId(), null, model(label), *linkBehaviors) {
        override fun populateItems(itemView: ItemView) {
            populateItemsHandler(itemView)
        }
    })
}