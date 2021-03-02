package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.*
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.AttributeModifier
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

open class Navbar(
    id: String,
    behaviors: List<Behavior> = emptyList(),
    positionModel: IModel<NavbarPosition?> = Model(null),
    styleModel: IModel<NavbarStyle> = NavbarStyle.LIGHT.model(),
    expandModel: IModel<NavbarExpand> = NavbarExpand.LG.model(),
    containerStyleModel: IModel<ContainerStyle> = Model(ContainerStyle.DEFAULT),
    createBrandHandler: Navbar.(id: String) -> Component = { id ->
        WebMarkupContainer(id).apply { isVisible = false }
    },
    populateCollapseItemsHandler: Navbar.(collapseItemView: RepeatingView) -> Any?
) : Panel(id) {

    init {
        this.add(CssClassAppender(BootstrapCssClass.NAVBAR))
        this.add(CssClassAppender(styleModel))
        this.add(CssClassAppender(positionModel))
        this.add(CssClassAppender(expandModel))

        val container = WebMarkupContainer("container")
        container.add(CssClassAppender(containerStyleModel))
        this.add(container)

        val brand = createBrandHandler("navbarBrand")
        container.add(brand)

        val navbarCollapse = WebMarkupContainer("navbarCollapse")
        navbarCollapse.outputMarkupId = true
        container.add(navbarCollapse)

        val navbarToggle = createNavbarToggler("navbarToggler")
        navbarToggle.add(AttributeModifier("data-bs-target") { "#${navbarCollapse.markupId}" })
        container.add(navbarToggle)

        val collapseItemView = RepeatingView("navbarCollapseItem")
        populateCollapseItemsHandler(collapseItemView)
        navbarCollapse.add(collapseItemView)

        behaviors.forEach { add(it) }
    }

    protected open fun createNavbarToggler(id: String): Component = NavbarToggler(id)
}