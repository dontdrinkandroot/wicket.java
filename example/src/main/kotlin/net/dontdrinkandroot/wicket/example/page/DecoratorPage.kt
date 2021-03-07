package net.dontdrinkandroot.wicket.example.page

import ` net`.dontdrinkandroot.wicket.extras.page.StandardBootstrapPage
import net.dontdrinkandroot.wicket.behavior.appendCssClass
import net.dontdrinkandroot.wicket.bootstrap.behavior.active
import net.dontdrinkandroot.wicket.bootstrap.component.item.dropdown
import net.dontdrinkandroot.wicket.bootstrap.component.item.pageLink
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.navbar
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.navbarNav
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarPosition
import net.dontdrinkandroot.wicket.bootstrap.css.Spacing
import net.dontdrinkandroot.wicket.bootstrap.headeritem.FontAwesomeCssHeaderItem
import net.dontdrinkandroot.wicket.example.component.BuildInfoItem
import net.dontdrinkandroot.wicket.example.component.ThemeDropdownItem
import net.dontdrinkandroot.wicket.example.getCurrentSession
import net.dontdrinkandroot.wicket.example.headeritem.HighlightJsInitHeaderItem
import net.dontdrinkandroot.wicket.example.page.component.*
import net.dontdrinkandroot.wicket.example.page.form.*
import net.dontdrinkandroot.wicket.markup.html.link.createPageLink
import org.apache.wicket.markup.head.CssContentHeaderItem
import org.apache.wicket.markup.head.CssUrlReferenceHeaderItem
import org.apache.wicket.markup.head.IHeaderResponse
import org.apache.wicket.markup.head.OnDomReadyHeaderItem
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

abstract class DecoratorPage<T> : StandardBootstrapPage<T> {

    constructor() : super()

    constructor(parameters: PageParameters) : super(parameters)

    constructor(model: IModel<T>?) : super(model)

    override fun createPageTitlePrefixModel(): IModel<String> = Model("wicket.example")

    override fun createNavbar(id: String) = navbar(
        id,
        positionModel = Model(NavbarPosition.FIXED_TOP),
        createBrandHandler = { id ->
            createPageLink(
                id,
                pageClass = HomePage::class.java,
                label = Model("wicket.example")
            )
        },
        behaviors = arrayOf(appendCssClass(BackgroundColor.LIGHT))
    ) {
        navbarNav(appendCssClass(Spacing.MARGIN_END_AUTO)) {
            pageLink("Getting Started", GettingStartedPage::class.java)
            pageLink("CSS", CssPage::class.java)
            pageLink("The Grid", GridPage::class.java)
            dropdown("Components", active { this.page is ComponentPage }) {
                pageLink("Buttons", ButtonPage::class.java)
                pageLink("Cards", CardPage::class.java)
                pageLink("Navs", NavPage::class.java)
                pageLink("Navbars", NavbarPage::class.java)
                pageLink("Breadcrumbs", BreadcrumbPage::class.java)
                pageLink("Badges", BadgePage::class.java)
                pageLink("Alerts and Feedback", AlertPage::class.java)
                pageLink("Progress Bars", ProgressBarPage::class.java)
                pageLink("Pagination", PaginationPage::class.java)
                pageLink("Dropdowns", DropdownPage::class.java)
                pageLink("Modals", ModalPage::class.java)
            }
            dropdown("Forms", active { this.page is FormPage }) {
                pageLink("Form Groups and Form Styles", FormGroupPage::class.java)
                pageLink("Input Groups", InputGroupPage::class.java)
                pageLink("Validations", ValidationPage::class.java)
                pageLink("Ajax Forms", AjaxFormPage::class.java)
            }
        }
        navbarNav {
            add(ThemeDropdownItem(newChildId()))
            add(BuildInfoItem(newChildId()))
        }
    }

    override fun renderHead(response: IHeaderResponse) {
        response.render(this.bootstrapHeaderItem)
        response.render(CssUrlReferenceHeaderItem(getCurrentSession().currentTheme!!.url, null, null))
        response.render(FontAwesomeCssHeaderItem())
        response.render(CssContentHeaderItem("body{padding-top: 56px;}", "bodyPadding"))
        response.render(
            CssContentHeaderItem(
                ".has-error .help-block .info{color: #737373;}",
                "infoHelpText"
            )
        )
        response.render(OnDomReadyHeaderItem(" $(\"a[rel='external']\").attr('target', '_blank');"))
        response.render(HighlightJsInitHeaderItem())
    }
}