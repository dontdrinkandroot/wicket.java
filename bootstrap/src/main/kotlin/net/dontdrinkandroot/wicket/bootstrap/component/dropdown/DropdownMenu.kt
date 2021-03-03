package net.dontdrinkandroot.wicket.bootstrap.component.dropdown

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemContainer
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.DropdownAlignment
import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class DropdownMenu(
    id: String,
    alignmentModel: IModel<DropdownAlignment?> = Model(null),
) : Panel(id), ItemContainer {

    init {
        this.add(CssClassAppender(BootstrapCssClass.DROPDOWN_MENU))
        this.add(CssClassAppender(alignmentModel))
        this.add(AttributeModifier("role", Model.of("menu")))
        // TODO: include aria-labelledby
        val itemView = RepeatingView("item")
        populateItems(itemView)
        this.add(itemView)
    }

    override val linkClass: CssClass?
        get() = BootstrapCssClass.DROPDOWN_ITEM

    abstract fun populateItems(itemView: RepeatingView)
}

fun dropdownMenu(
    id: String,
    alignmentModel: IModel<DropdownAlignment?> = Model(null),
    populateItemsHandler: DropdownMenu.(itemView: RepeatingView) -> Any?
) = object : DropdownMenu(id, alignmentModel) {
    override fun populateItems(itemView: RepeatingView) {
        populateItemsHandler(itemView)
    }
}