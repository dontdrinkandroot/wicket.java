package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownDividerItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownHeaderItem
import net.dontdrinkandroot.wicket.example.page.HomePage
import net.dontdrinkandroot.wicket.example.page.component.DropdownPage
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class DropdownPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun onInitialize() {
        super.onInitialize()
        val dropdownMenu: DropdownMenu = object : DropdownMenu("dropdownMenu") {
            override fun populateItems(itemView: RepeatingView) {
                this@DropdownPage.populateItems(itemView)
            }
        }
        this.add(dropdownMenu)
    }

    override fun createPageHeadingModel() = "Dropdowns".model()

    protected fun populateItems(itemView: RepeatingView)
    {
        itemView.add(
            BookmarkablePageLinkItem<Void>(
                itemView.newChildId(),
                labelModel = "Action".model(),
                pageClass = HomePage::class.java
            )
        )
        itemView.add(DropdownDividerItem(itemView.newChildId()))
        itemView.add(DropdownHeaderItem(itemView.newChildId(), Model.of("A Header")))
        itemView.add(
            BookmarkablePageLinkItem<Void>(
                itemView.newChildId(),
                labelModel = "Another Action".model(),
                pageClass = DropdownPage::class.java
            )
        )
    }
}