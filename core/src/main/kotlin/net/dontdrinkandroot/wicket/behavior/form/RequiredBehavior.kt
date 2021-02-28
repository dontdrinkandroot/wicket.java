package net.dontdrinkandroot.wicket.behavior.form

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.form.FormComponent

class RequiredBehavior : Behavior() {

    override fun onConfigure(component: Component) {
        if (component !is FormComponent<*>) throw RuntimeException("Component is not a FormComponent")
        component.isRequired = true
    }
}