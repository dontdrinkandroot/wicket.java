package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.LinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem
import net.dontdrinkandroot.wicket.bootstrap.component.nav.RepeatingNavPills
import net.dontdrinkandroot.wicket.bootstrap.component.nav.RepeatingNavTabs
import net.dontdrinkandroot.wicket.example.page.HomePage
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class NavPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Navs".model()

    override fun onInitialize() {
        super.onInitialize()

        val tabsDefault = object : RepeatingNavTabs<Void>("tabsDefault") {
            override fun populateItems(itemView: RepeatingView) {
                this@NavPage.populateItems(itemView)
            }
        }
        this.add(tabsDefault)

        val tabsJustified = object : RepeatingNavTabs<Void>("tabsJustified", justified = true) {
            override fun populateItems(itemView: RepeatingView) {
                this@NavPage.populateItems(itemView)
            }
        }
        this.add(tabsJustified)

        val pillsDefault = object : RepeatingNavPills<Void>("pillsDefault", stacked = false) {
            override fun populateItems(itemView: RepeatingView) {
                this@NavPage.populateItems(itemView)
            }
        }
        this.add(pillsDefault)

        val pillsStacked = object : RepeatingNavPills<Void>("pillsStacked", stacked = true) {
            override fun populateItems(itemView: RepeatingView) {
                this@NavPage.populateItems(itemView)
            }
        }
        this.add(pillsStacked)

        val pillsJustified = object : RepeatingNavPills<Void>("pillsJustified", justified = true) {
            override fun populateItems(itemView: RepeatingView) {
                this@NavPage.populateItems(itemView)
            }
        }
        this.add(pillsJustified)
    }

    protected fun populateItems(itemView: RepeatingView) {
        itemView.add(object : LinkItem<Void>(itemView.newChildId(), labelModel = "Active".model()) {
            override fun onClick() {
                /* Noop */
            }

            override val active: Boolean
                get() = true
        })
        itemView.add(object : RepeatingDropdownItem<Void?>(itemView.newChildId(), Model.of("Dropdown")) {
            override fun populateItems(itemView: RepeatingView) {
                itemView.add(
                    BookmarkablePageLinkItem<Void, HomePage>(
                        itemView.newChildId(),
                        Model.of("A Link"),
                        HomePage::class.java
                    )
                )
            }
        })
        val disabledItem: LinkItem<Void> =
            object : LinkItem<Void>(itemView.newChildId(), labelModel = "Disabled".model()) {
                override fun onClick() {
                    /* Noop */
                }
            }
        disabledItem.add(DisabledCssBehavior())
        disabledItem.isEnabled = false
        itemView.add(disabledItem)
    }
}