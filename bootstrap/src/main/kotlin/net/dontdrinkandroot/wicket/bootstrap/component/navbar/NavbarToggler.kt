package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.aria.Aria
import net.dontdrinkandroot.wicket.behavior.aria.AriaAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.behavior.AttributeAppender
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.ResourceModel

class NavbarToggler(id: String) : Panel(id) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.NAVBAR_TOGGLER))
        this.add(AttributeAppender("data-bs-toggle", "collapse"))
        this.add(AriaAppender(Aria.EXPANDED, "false"))
        this.add(AriaAppender(Aria.LABEL, ResourceModel("navbar.toggler", "Toggle navigation")))
    }
}