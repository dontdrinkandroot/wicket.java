package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.WebMarkupContainer

class DropdownDividerItem(id: String) : WebMarkupContainer(id), Item {
    init {
        this.add(CssClassAppender(BootstrapCssClass.DROPDOWN_DIVIDER))
        this.add(AttributeModifier("role", "separator"))
    }
}

fun ItemView.divider() {
    this.add(DropdownDividerItem(newChildId()))
}