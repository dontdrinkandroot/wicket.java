package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.disabled
import net.dontdrinkandroot.wicket.bootstrap.behavior.active
import net.dontdrinkandroot.wicket.bootstrap.behavior.disabledCss
import net.dontdrinkandroot.wicket.bootstrap.component.item.*
import net.dontdrinkandroot.wicket.bootstrap.component.nav.repeatingNavPills
import net.dontdrinkandroot.wicket.bootstrap.component.nav.repeatingNavTabs
import net.dontdrinkandroot.wicket.bootstrap.css.Flex
import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
import net.dontdrinkandroot.wicket.example.page.HomePage
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class NavPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = Model("Navs")

    override fun onInitialize() {
        super.onInitialize()

        val tabsDefault = repeatingNavTabs("tabsDefault") { this@NavPage.populateItems(this) }
        this.add(tabsDefault)

        val tabsJustified = repeatingNavTabs(
            "tabsJustified",
            itemAlignmentModel = Model(NavItemAlignment.JUSTIFIED)
        )
        { this@NavPage.populateItems(this) }
        this.add(tabsJustified)

        val tabsFill = repeatingNavTabs(
            "tabsFill",
            itemAlignmentModel = Model(NavItemAlignment.FILL)
        )
        { this@NavPage.populateItems(this) }
        this.add(tabsFill)

        val pillsDefault = repeatingNavPills("pillsDefault") { this@NavPage.populateItems(this) }
        this.add(pillsDefault)

        val pillsJustified = repeatingNavPills(
            "pillsJustified",
            itemAlignmentModel = Model(NavItemAlignment.JUSTIFIED)
        )
        { this@NavPage.populateItems(this) }
        this.add(pillsJustified)

        val pillsFill = repeatingNavPills(
            "pillsFill",
            itemAlignmentModel = Model(NavItemAlignment.FILL)
        )
        { this@NavPage.populateItems(this) }
        this.add(pillsFill)

        val pillsColumn = repeatingNavPills(
            "pillsColumn",
            itemAlignmentModel = Model(NavItemAlignment.FILL)
        )
        { this@NavPage.populateItems(this) }
        pillsColumn.add(CssClassAppender(Flex.COLUMN))
        this.add(pillsColumn)
    }

    protected fun populateItems(itemView: ItemView) {
        itemView.link("Active", active { true }) {}
        itemView.dropdown("Dropdown") {
            pageLink("A link", HomePage::class)
        }
        itemView.link("Disabled", disabled(), disabledCss()) {}
    }
}