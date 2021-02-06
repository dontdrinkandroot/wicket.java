package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.LinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem
import net.dontdrinkandroot.wicket.bootstrap.component.nav.RepeatingNavPills
import net.dontdrinkandroot.wicket.bootstrap.component.nav.RepeatingNavTabs
import net.dontdrinkandroot.wicket.example.page.HomePage
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class NavPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel(): IModel<String> {
        return Model.of("Navs")
    }

    override fun onInitialize() {
        super.onInitialize()
        val tabsDefault: RepeatingNavTabs<*> = object : RepeatingNavTabs<Void?>("tabsDefault")
        {
            override fun populateItems(itemView: RepeatingView)
            {
                this@NavPage.populateItems(itemView)
            }
        }
        this.add(tabsDefault)
        val tabsJustified: RepeatingNavTabs<*> = object : RepeatingNavTabs<Void?>("tabsJustified")
        {
            override fun populateItems(itemView: RepeatingView)
            {
                this@NavPage.populateItems(itemView)
            }
        }
        tabsJustified.setJustified(true)
        this.add(tabsJustified)
        val pillsDefault: RepeatingNavPills<*> = object : RepeatingNavPills<Void?>("pillsDefault")
        {
            override fun populateItems(itemView: RepeatingView)
            {
                this@NavPage.populateItems(itemView)
            }
        }
        this.add(pillsDefault)
        val pillsStacked: RepeatingNavPills<*> = object : RepeatingNavPills<Void?>("pillsStacked")
        {
            override fun populateItems(itemView: RepeatingView)
            {
                this@NavPage.populateItems(itemView)
            }
        }
        pillsStacked.setStacked(true)
        this.add(pillsStacked)
        val pillsJustified: RepeatingNavPills<*> = object : RepeatingNavPills<Void?>("pillsJustified")
        {
            override fun populateItems(itemView: RepeatingView)
            {
                this@NavPage.populateItems(itemView)
            }
        }
        pillsJustified.setJustified(true)
        this.add(pillsJustified)
    }

    protected fun populateItems(itemView: RepeatingView)
    {
        itemView.add(object : LinkItem<Void?>(itemView.newChildId(), Model.of("Active"))
        {
            override fun onClick()
            {
                /* Noop */
            }

            override fun isActive(): Boolean
            {
                return true
            }
        })
        itemView.add(object : RepeatingDropdownItem<Void?>(itemView.newChildId(), Model.of("Dropdown"))
        {
            override fun populateItems(itemView: RepeatingView)
            {
                itemView.add(
                    BookmarkablePageLinkItem<Void, HomePage>(
                        itemView.newChildId(),
                        Model.of("A Link"),
                        HomePage::class.java
                    )
                )
            }
        })
        val disabledItem: LinkItem<Void> = object : LinkItem<Void>(itemView.newChildId(), Model.of("Disabled"))
        {
            override fun onClick()
            {
                /* Noop */
            }
        }
        disabledItem.add(DisabledCssBehavior())
        disabledItem.isEnabled = false
        itemView.add(disabledItem)
    }
}