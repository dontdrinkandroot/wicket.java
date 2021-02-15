package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropdownToggleBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.model.IModel

abstract class DropdownItem<T>(id: String, model: IModel<T>? = null, labelModel: IModel<String>) :
    AbstractLinkItem<T, AbstractLink>(id, model, labelModel) {

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