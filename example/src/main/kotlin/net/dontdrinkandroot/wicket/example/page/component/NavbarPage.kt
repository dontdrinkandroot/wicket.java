package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownDividerItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownHeaderItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.*
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarStyle
import net.dontdrinkandroot.wicket.example.component.NavbarForm
import net.dontdrinkandroot.wicket.example.page.HomePage
import net.dontdrinkandroot.wicket.markup.html.link.BookmarkablePageLink
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class NavbarPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Navbars".model()

    override fun onInitialize() {
        super.onInitialize()
        val navbarLight = createExampleNavbar("navbarLight")
        navbarLight.add(CssClassAppender(BackgroundColor.LIGHT))
        this.add(navbarLight)

        val navbarDark = createExampleNavbar("navbarDark", styleModel = Model(NavbarStyle.DARK))
        navbarDark.add(CssClassAppender(BackgroundColor.DARK))
        this.add(navbarDark)
    }

    protected fun createExampleNavbar(id: String, styleModel: IModel<NavbarStyle> = Model(null)): Navbar = navbar(
        id,
        styleModel = styleModel,
        createBrandHandler = { id ->
            BookmarkablePageLink<Void>(id, pageClass = HomePage::class.java, bodyModel = Model("Brand"))
        }
    )
    { collapseItemView ->
        collapseItemView.add(
            repeatingNavbarNav(
                collapseItemView.newChildId()
            )
            { itemView ->
                itemView.add(object :
                    RepeatingDropdownItem<Void>(itemView.newChildId(), labelModel = Model.of("Dropdown")) {
                    override fun populateItems(itemView: RepeatingView) {
                        itemView.add(
                            BookmarkablePageLinkItem<Void>(
                                itemView.newChildId(),
                                labelModel = Model.of("Action"),
                                pageClass = HomePage::class
                            )
                        )
                        itemView.add(DropdownDividerItem(itemView.newChildId()))
                        itemView.add(DropdownHeaderItem(itemView.newChildId(), Model.of("A Header")))
                        itemView.add(
                            BookmarkablePageLinkItem<Void>(
                                itemView.newChildId(),
                                labelModel = Model.of("Another Action"),
                                pageClass = HomePage::class
                            )
                        )
                    }
                })
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = Model.of("Link"),
                        pageClass = NavbarPage::class
                    )
                )
            }
        )
        val form = NavbarForm(collapseItemView.newChildId())
        collapseItemView.add(form)
        val text = NavbarText(collapseItemView.newChildId(), Model.of("Text"))
        collapseItemView.add(text)
        collapseItemView.add(NavbarButtonLink<Void>(
            collapseItemView.newChildId(),
            bodyModel = Model("Button"),
            alignmentModel = NavbarAlignment.RIGHT.model()
        ) {})
    }
}