package net.dontdrinkandroot.wicket.markup.html

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

class RepeatingPanel<T>(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    populateChildrenHandler: RepeatingPanel<T>.(childView: RepeatingView) -> Component
) : GenericPanel<T>(id, model) {

    init {
        val childView = RepeatingView("child")
        populateChildrenHandler(childView)
        add(childView)
        behaviors.forEach { add(it) }
    }
}
