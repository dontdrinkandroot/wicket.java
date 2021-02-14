package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior

class NavbarFormBehavior : Behavior() {

    override fun bind(component: Component) {
        super.bind(component)
        component.add(CssClassAppender(BootstrapCssClass.NAVBAR_FORM))
    }
}