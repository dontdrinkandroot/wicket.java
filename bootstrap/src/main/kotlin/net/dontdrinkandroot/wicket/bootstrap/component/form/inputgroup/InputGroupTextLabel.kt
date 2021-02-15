package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel

class InputGroupTextLabel(id: String, model: IModel<*>? = null) : Label(id, model) {

    override fun onInitialize() {
        super.onInitialize()
        add(CssClassAppender(BootstrapCssClass.INPUT_GROUP_TEXT))
    }
}