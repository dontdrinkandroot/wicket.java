package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.LinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem
import net.dontdrinkandroot.wicket.bootstrap.component.nav.repeatingNavPills
import net.dontdrinkandroot.wicket.bootstrap.component.nav.repeatingNavTabs
import net.dontdrinkandroot.wicket.bootstrap.css.Flex
import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
import net.dontdrinkandroot.wicket.example.page.HomePage
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class NavPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Navs".model()

    override fun onInitialize() {
        super.onInitialize()

        val tabsDefault = repeatingNavTabs("tabsDefault") { itemView -> this@NavPage.populateItems(itemView) }
        this.add(tabsDefault)

        val tabsJustified = repeatingNavTabs(
            "tabsJustified",
            itemAlignmentModel = Model(NavItemAlignment.JUSTIFIED)
        )
        { itemView -> this@NavPage.populateItems(itemView) }
        this.add(tabsJustified)

        val tabsFill = repeatingNavTabs(
            "tabsFill",
            itemAlignmentModel = Model(NavItemAlignment.FILL)
        )
        { itemView -> this@NavPage.populateItems(itemView) }
        this.add(tabsFill)

        val pillsDefault = repeatingNavPills("pillsDefault") { itemView -> this@NavPage.populateItems(itemView) }
        this.add(pillsDefault)

        val pillsJustified = repeatingNavPills(
            "pillsJustified",
            itemAlignmentModel = Model(NavItemAlignment.JUSTIFIED)
        )
        { itemView -> this@NavPage.populateItems(itemView) }
        this.add(pillsJustified)

        val pillsFill = repeatingNavPills(
            "pillsFill",
            itemAlignmentModel = Model(NavItemAlignment.FILL)
        )
        { itemView -> this@NavPage.populateItems(itemView) }
        this.add(pillsFill)

        val pillsColumn = repeatingNavPills(
            "pillsColumn",
            itemAlignmentModel = Model(NavItemAlignment.FILL)
        )
        { itemView -> this@NavPage.populateItems(itemView) }
        pillsColumn.add(CssClassAppender(Flex.COLUMN))
        this.add(pillsColumn)
    }

    protected fun populateItems(itemView: RepeatingView) {
        itemView.add(object : LinkItem<Void>(itemView.newChildId(), labelModel = "Active".model()) {
            override fun onClick() {
                /* Noop */
            }

            override val active: Boolean
                get() = true
        })
        itemView.add(object : RepeatingDropdownItem<Void?>(itemView.newChildId(), labelModel = Model.of("Dropdown")) {
            override fun populateItems(itemView: RepeatingView) {
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "A Link".model(),
                        pageClass = HomePage::class
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