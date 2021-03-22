package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.disabled
import net.dontdrinkandroot.wicket.bootstrap.behavior.active
import net.dontdrinkandroot.wicket.bootstrap.behavior.disabledCss
import net.dontdrinkandroot.wicket.bootstrap.component.item.*
import net.dontdrinkandroot.wicket.bootstrap.component.nav.createRepeatingNavTabs
import net.dontdrinkandroot.wicket.bootstrap.component.nav.repeatingNavPills
import net.dontdrinkandroot.wicket.bootstrap.css.Flex
import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
import net.dontdrinkandroot.wicket.example.page.HomePage
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class NavPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = Model("Navs")

    override fun onInitialize() {
        super.onInitialize()

        val tabsDefault = createRepeatingNavTabs("tabsDefault") { this@NavPage.populateItems(this) }
        this.add(tabsDefault)

        val tabsJustified = createRepeatingNavTabs(
            "tabsJustified",
            itemAlignmentModel = Model(NavItemAlignment.JUSTIFIED)
        )
        { this@NavPage.populateItems(this) }
        this.add(tabsJustified)

        val tabsFill = createRepeatingNavTabs(
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
        itemView.addLink("Active", active { true }) {}
        itemView.addDropdown("Dropdown") {
            addPageLink("A link", HomePage::class)
        }
        itemView.addLink("Disabled", disabled(), disabledCss()) {}
    }
}