package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.nav.AbstractRepeatingNav
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.markup.ComponentTag

open class RepeatingNavbarNav<T>(id: String) : AbstractRepeatingNav<T>(id) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.NAVBAR_NAV))
    }

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "ul"
        super.onComponentTag(tag)
    }
}