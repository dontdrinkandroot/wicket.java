package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel

class NavbarText(id: String, model: IModel<*>? = null) : Label(id, model) {

    init {
        add(CssClassAppender(BootstrapCssClass.NAVBAR_TEXT))
    }
}