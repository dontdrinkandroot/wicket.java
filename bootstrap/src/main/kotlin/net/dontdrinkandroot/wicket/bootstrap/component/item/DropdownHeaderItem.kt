package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.model.IModel

class DropdownHeaderItem(id: String, labelModel: IModel<String>) : LabelItem(id, labelModel) {
    init {
        add(CssClassAppender(BootstrapCssClass.DROPDOWN_HEADER))
    }
}