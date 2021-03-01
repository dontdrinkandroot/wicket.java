package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.nav.AbstractRepeatingNav
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

class RepeatingNavbarNav<T>(
    id: String,
    model: IModel<T>? = null,
    behaviors: List<Behavior> = emptyList(),
    populateItemsHandler: AbstractRepeatingNav<T>.(itemView: RepeatingView) -> Any?
) : AbstractRepeatingNav<T>(id, model, populateItemsHandler) {

    init {
        add(CssClassAppender(BootstrapCssClass.NAVBAR_NAV))
        behaviors.forEach { add(it) }
    }

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "ul"
        super.onComponentTag(tag)
    }
}