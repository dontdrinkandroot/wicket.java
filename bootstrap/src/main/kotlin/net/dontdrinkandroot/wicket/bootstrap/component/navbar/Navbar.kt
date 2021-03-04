package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.cssClass
import net.dontdrinkandroot.wicket.behavior.invisible
import net.dontdrinkandroot.wicket.behavior.outputMarkupId
import net.dontdrinkandroot.wicket.bootstrap.css.*
import net.dontdrinkandroot.wicket.markup.html.webMarkupContainer
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.AttributeModifier
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class NavbarCollapseView(id: String) : RepeatingView(id)

abstract class Navbar(
    id: String,
    positionModel: IModel<NavbarPosition?> = Model(null),
    styleModel: IModel<NavbarStyle> = NavbarStyle.LIGHT.model(),
    expandModel: IModel<NavbarExpand> = NavbarExpand.LG.model(),
    containerStyleModel: IModel<ContainerStyle> = Model(ContainerStyle.DEFAULT),
    vararg behaviors: Behavior
) : Panel(id) {

    init {
        this.add(cssClass(BootstrapCssClass.NAVBAR))
        this.add(cssClass(styleModel))
        this.add(cssClass(positionModel))
        this.add(cssClass(expandModel))

        val container = webMarkupContainer("container", CssClassAppender(containerStyleModel))
        this.add(container)

        val brand = createBrand("navbarBrand")
        container.add(brand)

        val navbarCollapse = webMarkupContainer("navbarCollapse", outputMarkupId())
        container.add(navbarCollapse)

        val navbarToggle = createNavbarToggler("navbarToggler")
        navbarToggle.add(AttributeModifier("data-bs-target") { "#${navbarCollapse.markupId}" })
        container.add(navbarToggle)

        val collapseItemView = NavbarCollapseView("navbarCollapseItem")
        populateCollapseItems(collapseItemView)
        navbarCollapse.add(collapseItemView)

        add(*behaviors)
    }

    protected open fun createBrand(id: String): Component = webMarkupContainer(id, invisible())

    protected open fun createNavbarToggler(id: String): Component = NavbarToggler(id)

    abstract fun populateCollapseItems(collapseView: NavbarCollapseView)
}

fun navbar(
    id: String,
    positionModel: IModel<NavbarPosition?> = Model(null),
    styleModel: IModel<NavbarStyle> = NavbarStyle.LIGHT.model(),
    expandModel: IModel<NavbarExpand> = NavbarExpand.LG.model(),
    containerStyleModel: IModel<ContainerStyle> = Model(ContainerStyle.DEFAULT),
    createBrandHandler: Navbar.(id: String) -> Component = { id -> webMarkupContainer(id, invisible()) },
    vararg behaviors: Behavior,
    populateCollapseItemsHandler: NavbarCollapseView.() -> Any?
) = object : Navbar(id, positionModel, styleModel, expandModel, containerStyleModel, *behaviors) {

    override fun createBrand(id: String) = createBrandHandler(id)

    override fun populateCollapseItems(collapseView: NavbarCollapseView) {
        populateCollapseItemsHandler(collapseView)
    }
}