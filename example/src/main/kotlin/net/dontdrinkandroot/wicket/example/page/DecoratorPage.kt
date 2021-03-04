package net.dontdrinkandroot.wicket.example.page

import ` net`.dontdrinkandroot.wicket.extras.page.StandardBootstrapPage
import net.dontdrinkandroot.wicket.behavior.cssClass
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
import net.dontdrinkandroot.wicket.markup.html.link.BookmarkablePageLink
import net.dontdrinkandroot.wicket.model.model
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

    override fun createPageTitlePrefixModel() = "wicket.example".model()

    override fun createNavbar(id: String) = navbar(
        id,
        positionModel = Model(NavbarPosition.FIXED_TOP),
        createBrandHandler = { id ->
            BookmarkablePageLink<Void>(
                id,
                pageClass = HomePage::class.java,
                bodyModel = Model("wicket.example")
            )
        },
        behaviors = arrayOf(cssClass(BackgroundColor.LIGHT))
    ) {
        navbarNav(cssClass(Spacing.MARGIN_END_AUTO)) {
            pageLink("Getting Started", GettingStartedPage::class)
            pageLink("CSS", CssPage::class)
            pageLink("The Grid", GridPage::class)
            dropdown("Components", active { this.page is ComponentPage }) {
                pageLink("Buttons", ButtonPage::class)
                pageLink("Cards", CardPage::class)
                pageLink("Navs", NavPage::class)
                pageLink("Navbars", NavbarPage::class)
                pageLink("Breadcrumbs", BreadcrumbPage::class)
                pageLink("Badges", BadgePage::class)
                pageLink("Alerts and Feedback", AlertPage::class)
                pageLink("Progress Bars", ProgressBarPage::class)
                pageLink("Pagination", PaginationPage::class)
                pageLink("Dropdowns", DropdownPage::class)
                pageLink("Modals", ModalPage::class)
            }
            dropdown("Forms", active { this.page is FormPage }) {
                pageLink("Form Groups and Form Styles", FormGroupPage::class)
                pageLink("Input Groups", InputGroupPage::class)
                pageLink("Validations", ValidationPage::class)
                pageLink("Ajax Forms", AjaxFormPage::class)
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