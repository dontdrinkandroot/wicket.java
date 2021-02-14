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

abstract class DropdownMenu(id: String) : Panel(id), ItemContainer {

    private val alignmentModel: IModel<DropdownAlignment?> = Model(null)

    override fun onInitialize() {
        super.onInitialize()
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

    fun setAlignment(alignment: DropdownAlignment): DropdownMenu {
        alignmentModel.setObject(alignment)
        return this
    }

    protected abstract fun populateItems(itemView: RepeatingView)
}