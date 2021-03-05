package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.dropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownDividerItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownHeaderItem
import net.dontdrinkandroot.wicket.example.page.HomePage
import net.dontdrinkandroot.wicket.example.page.component.DropdownPage
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class DropdownPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun onInitialize() {
        super.onInitialize()
        val dropdownMenu: DropdownMenu = dropdownMenu("dropdownMenu") {
            this@DropdownPage.populateItems(this)
        }
        this.add(dropdownMenu)
    }

    override fun createPageHeadingModel() = Model("Dropdowns")

    protected fun populateItems(itemView: RepeatingView) {
        itemView.add(
            BookmarkablePageLinkItem<Void>(
                itemView.newChildId(),
                labelModel = Model("Action"),
                pageClass = HomePage::class
            )
        )
        itemView.add(DropdownDividerItem(itemView.newChildId()))
        itemView.add(DropdownHeaderItem(itemView.newChildId(), Model.of("A Header")))
        itemView.add(
            BookmarkablePageLinkItem<Void>(
                itemView.newChildId(),
                labelModel = Model("Another Action"),
                pageClass = DropdownPage::class
            )
        )
    }
}