package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.Navbar
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.RepeatingNavbarNav
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
import net.dontdrinkandroot.wicket.extras.page.StandardBootstrapPage
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Component
import org.apache.wicket.markup.head.CssContentHeaderItem
import org.apache.wicket.markup.head.CssUrlReferenceHeaderItem
import org.apache.wicket.markup.head.IHeaderResponse
import org.apache.wicket.markup.head.OnDomReadyHeaderItem
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

abstract class DecoratorPage<T> : StandardBootstrapPage<T> {

    constructor() : super()

    constructor(parameters: PageParameters) : super(parameters)

    constructor(model: IModel<T>?) : super(model)

    override fun createPageTitlePrefixModel() = "wicket.example".model()

    override fun createNavbar(id: String): Navbar {
        val navbar: Navbar = object : Navbar(id) {
            override fun createBrand(id: String): Component {
                val brandLink: BookmarkablePageLink<Void> = BookmarkablePageLink(id, HomePage::class.java)
                brandLink.body = Model.of("wicket.example")
                return brandLink
            }

            override fun populateCollapseItems(collapseItemView: RepeatingView) {
                super.populateCollapseItems(collapseItemView)
                val leftItems: RepeatingNavbarNav<*> =
                    object : RepeatingNavbarNav<Void?>(collapseItemView.newChildId()) {
                        override fun populateItems(itemView: RepeatingView) {
                            super.populateItems(itemView)
                            populateNavbarLeftItems(itemView)
                        }
                    }
                leftItems.add(CssClassAppender(Spacing(Spacing.Property.MARGIN, Spacing.Size.AUTO, Spacing.Side.END)))
                collapseItemView.add(leftItems)
                val rightItems: RepeatingNavbarNav<*> =
                    object : RepeatingNavbarNav<Void?>(collapseItemView.newChildId()) {
                        override fun populateItems(itemView: RepeatingView) {
                            super.populateItems(itemView)
                            itemView.add(ThemeDropdownItem(itemView.newChildId()))
                            itemView.add(BuildInfoItem(itemView.newChildId()))
                        }
                    }
                collapseItemView.add(rightItems)
            }
        }
        navbar.setPosition(NavbarPosition.FIXED_TOP)
        navbar.add(CssClassAppender(BackgroundColor.LIGHT))
        return navbar
    }

    protected fun populateNavbarLeftItems(leftItemView: RepeatingView) {
        leftItemView.add(
            BookmarkablePageLinkItem<Void, GettingStartedPage>(
                leftItemView.newChildId(),
                "Getting Started".model(),
                GettingStartedPage::class.java
            )
        )
        leftItemView.add(
            BookmarkablePageLinkItem<Void, CssPage>(leftItemView.newChildId(), "CSS".model(), CssPage::class.java)
        )
        leftItemView.add(
            BookmarkablePageLinkItem<Void, GridPage>(
                leftItemView.newChildId(),
                "The Grid".model(),
                GridPage::class.java
            )
        )
        leftItemView.add(object : RepeatingDropdownItem<Void>(leftItemView.newChildId(), "Components".model()) {
            override fun populateItems(itemView: RepeatingView) {
                itemView.add(
                    BookmarkablePageLinkItem<Void, ButtonPage>(
                        itemView.newChildId(),
                        "Buttons".model(),
                        ButtonPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, PanelPage>(
                        itemView.newChildId(),
                        "Panels".model(),
                        PanelPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, NavPage>(
                        itemView.newChildId(),
                        "Navs".model(),
                        NavPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, NavbarPage>(
                        itemView.newChildId(),
                        "Navbars".model(),
                        NavbarPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, BreadcrumbPage>(
                        itemView.newChildId(),
                        "Breadcrumbs".model(),
                        BreadcrumbPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, BadgePage>(
                        itemView.newChildId(),
                        "Badges".model(),
                        BadgePage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, AlertPage>(
                        itemView.newChildId(),
                        "Alerts and Feedback".model(),
                        AlertPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, ProgressBarPage>(
                        itemView.newChildId(),
                        "Progress Bars".model(),
                        ProgressBarPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, PaginationPage>(
                        itemView.newChildId(),
                        "Pagination".model(),
                        PaginationPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, DropdownPage>(
                        itemView.newChildId(),
                        "Dropdowns".model(),
                        DropdownPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, ModalPage>(
                        itemView.newChildId(),
                        "Modals".model(),
                        ModalPage::class.java
                    )
                )
            }

            override val active: Boolean
                get() = this.page is ComponentPage
        })
        leftItemView.add(object : RepeatingDropdownItem<Void?>(leftItemView.newChildId(), Model.of("Forms")) {
            override fun populateItems(itemView: RepeatingView) {
                itemView.add(
                    BookmarkablePageLinkItem<Void, FormGroupPage>(
                        itemView.newChildId(),
                        Model.of("Form Groups and Form Styles"),
                        FormGroupPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, InputGroupPage>(
                        itemView.newChildId(),
                        Model.of("Input Groups"),
                        InputGroupPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, ValidationPage>(
                        itemView.newChildId(),
                        Model.of("Validations"),
                        ValidationPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void, AjaxFormPage>(
                        itemView.newChildId(),
                        Model.of("Ajax Forms"),
                        AjaxFormPage::class.java
                    )
                )
            }

            override val active: Boolean
                get() = this.page is FormPage
        })
    }

    override fun renderHead(response: IHeaderResponse) {
        response.render(this.bootstrapJavaScriptHeaderItem)
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