package net.dontdrinkandroot.wicket.example.page

import ` net`.dontdrinkandroot.wicket.extras.page.StandardBootstrapPage
import net.dontdrinkandroot.wicket.behavior.cssClass
import net.dontdrinkandroot.wicket.bootstrap.behavior.active
import net.dontdrinkandroot.wicket.bootstrap.component.item.addDropdown
import net.dontdrinkandroot.wicket.bootstrap.component.item.addPageLink
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.addNavbarNav
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.navbar
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
import net.dontdrinkandroot.wicket.markup.html.link.pageLink
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
        position = Model(NavbarPosition.FIXED_TOP),
        createBrandHandler = { id ->
            pageLink(
                id,
                pageClass = HomePage::class,
                label = Model("wicket.example")
            )
        },
        behaviors = arrayOf(cssClass(BackgroundColor.LIGHT))
    ) {
        addNavbarNav(cssClass(Spacing.MARGIN_END_AUTO)) {
            addPageLink("Getting Started", GettingStartedPage::class)
            addPageLink("CSS", CssPage::class)
            addPageLink("The Grid", GridPage::class)
            addDropdown("Components", active { page is ComponentPage }) {
                addPageLink("Buttons", ButtonPage::class)
                addPageLink("Cards", CardPage::class)
                addPageLink("Navs", NavPage::class)
                addPageLink("Navbars", NavbarPage::class)
                addPageLink("Breadcrumbs", BreadcrumbPage::class)
                addPageLink("Badges", BadgePage::class)
                addPageLink("Alerts and Feedback", AlertPage::class)
                addPageLink("Progress Bars", ProgressBarPage::class)
                addPageLink("Pagination", PaginationPage::class)
                addPageLink("Dropdowns", DropdownPage::class)
                addPageLink("Modals", ModalPage::class)
            }
            addDropdown("Forms", active { page is FormPage }) {
                addPageLink("Form Groups and Form Styles", FormGroupPage::class)
                addPageLink("Input Groups", InputGroupPage::class)
                addPageLink("Validations", ValidationPage::class)
                addPageLink("Ajax Forms", AjaxFormPage::class)
            }
        }
        addNavbarNav {
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