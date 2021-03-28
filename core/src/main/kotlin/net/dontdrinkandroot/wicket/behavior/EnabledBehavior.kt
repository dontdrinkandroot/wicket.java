package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class EnabledBehavior(private val enabledModel: IModel<Boolean>) : Behavior() {

    override fun onConfigure(component: Component) {
        component.isEnabled = true == enabledModel.getObject()
    }

    override fun detach(component: Component) {
        enabledModel.detach()
    }
}

fun enabled(enabled: Boolean) = EnabledBehavior(Model(enabled))

fun disabled() = EnabledBehavior(Model(false))