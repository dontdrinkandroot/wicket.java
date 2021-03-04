package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.kmodel.kModel
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

class EnabledBehavior(private val enabledModel: IModel<Boolean>) : Behavior() {

    override fun onConfigure(component: Component) {
        component.isEnabled = true == enabledModel.getObject()
    }

    override fun detach(component: Component) {
        enabledModel.detach()
    }
}

fun enabled(enabled: Boolean) = EnabledBehavior(kModel(enabled))

fun disabled() = EnabledBehavior(kModel(false))