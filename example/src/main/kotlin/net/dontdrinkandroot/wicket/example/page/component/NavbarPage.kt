package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.item.addDivider
import net.dontdrinkandroot.wicket.bootstrap.component.item.addDropdown
import net.dontdrinkandroot.wicket.bootstrap.component.item.addHeader
import net.dontdrinkandroot.wicket.bootstrap.component.item.addPageLink
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.*
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarStyle
import net.dontdrinkandroot.wicket.example.component.NavbarForm
import net.dontdrinkandroot.wicket.example.page.HomePage
import net.dontdrinkandroot.wicket.markup.html.link.pageLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class NavbarPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = Model("Navbars")

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
        style = styleModel,
        createBrandHandler = { id ->
            pageLink(id, pageClass = HomePage::class, label = Model("Brand"))
        }
    )
    {
        addNavbarNav()
        {
            addDropdown("Dropdown") {
                addPageLink("Action", HomePage::class)
                addDivider()
                addHeader("A header")
                addPageLink("Another Action", HomePage::class)
            }
            addPageLink("Link", NavbarPage::class)
        }

        val form = NavbarForm(newChildId())
        add(form)

        val text = NavbarText(newChildId(), Model.of("Text"))
        add(text)
        add(NavbarButtonLink<Void>(
            newChildId(),
            bodyModel = Model("Button"),
            alignmentModel = Model(NavbarAlignment.RIGHT)
        ) {})
    }
}