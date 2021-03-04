package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class VisibleBehavior(private val visibleModel: IModel<Boolean>) : Behavior() {

    override fun onConfigure(component: Component) {
        component.isVisible = true == visibleModel.getObject()
    }

    override fun detach(component: Component) {
        visibleModel.detach()
    }
}

fun invisible() = VisibleBehavior(Model(false))