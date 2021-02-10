package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownDividerItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownHeaderItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.Navbar
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.NavbarButton
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.NavbarText
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.RepeatingNavbarNav
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarStyle
import net.dontdrinkandroot.wicket.example.component.NavbarForm
import net.dontdrinkandroot.wicket.example.page.HomePage
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Component
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class NavbarPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Navbars".model()

    override fun onInitialize() {
        super.onInitialize()
        val navbarLight = createExampleNavbar("navbarLight")
        navbarLight.add(CssClassAppender(BackgroundColor.LIGHT))
        this.add(navbarLight)
        val navbarDark = createExampleNavbar("navbarDark")
        navbarDark.setStyle(NavbarStyle.DARK)
        navbarDark.add(CssClassAppender(BackgroundColor.DARK))
        this.add(navbarDark)
    }

    protected fun createExampleNavbar(id: String?): Navbar {
        return object : Navbar(id) {
            override fun createBrand(id: String): Component {
                val brandLink: BookmarkablePageLink<*> = BookmarkablePageLink<Void, HomePage>(id, HomePage::class.java)
                brandLink.body = Model.of("Brand")
                return brandLink
            }

            override fun populateCollapseItems(collapseItemView: RepeatingView) {
                super.populateCollapseItems(collapseItemView)
                collapseItemView.add(object : RepeatingNavbarNav<Void?>(collapseItemView.newChildId()) {
                    override fun populateItems(itemView: RepeatingView) {
                        super.populateItems(itemView)
                        itemView.add(object :
                            RepeatingDropdownItem<Void?>(itemView.newChildId(), Model.of("Dropdown")) {
                            override fun populateItems(itemView: RepeatingView) {
                                itemView.add(
                                    BookmarkablePageLinkItem<Void>(
                                        itemView.newChildId(),
                                        labelModel = Model.of("Action"),
                                        pageClass = HomePage::class.java
                                    )
                                )
                                itemView.add(DropdownDividerItem(itemView.newChildId()))
                                itemView.add(DropdownHeaderItem(itemView.newChildId(), Model.of("A Header")))
                                itemView.add(
                                    BookmarkablePageLinkItem<Void>(
                                        itemView.newChildId(),
                                        labelModel = Model.of("Another Action"),
                                        pageClass = HomePage::class.java
                                    )
                                )
                            }
                        })
                        itemView.add(
                            BookmarkablePageLinkItem<Void>(
                                itemView.newChildId(),
                                labelModel = Model.of("Link"),
                                pageClass = NavbarPage::class.java
                            )
                        )
                    }
                })
                val form = NavbarForm(collapseItemView.newChildId())
                collapseItemView.add(form)
                val text = NavbarText(collapseItemView.newChildId(), Model.of("Text"))
                collapseItemView.add(text)
                val button: NavbarButton<*> = object :
                    NavbarButton<Void>(collapseItemView.newChildId(), alignmentModel = NavbarAlignment.RIGHT.model()) {
                    override fun onClick() {
                        /* Noop */
                    }
                }
                button.body = Model.of("Button")
                collapseItemView.add(button)
            }
        }
    }
}