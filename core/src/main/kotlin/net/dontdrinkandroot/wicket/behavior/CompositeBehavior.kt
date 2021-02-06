package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.head.IHeaderResponse

/**
 * A Behavior that bundles multiple behaviors. Can be useful for adding/removing/disabling a behavior at once.
 */
open class CompositeBehavior(private val behaviors: MutableCollection<Behavior>) : Behavior() {

    constructor(vararg behaviors: Behavior) : this(mutableListOf(*behaviors))

    override fun afterRender(component: Component) {
        for (behavior in behaviors) {
            behavior.afterRender(component)
        }
    }

    override fun beforeRender(component: Component) {
        for (behavior in behaviors) {
            behavior.beforeRender(component)
        }
    }

    override fun bind(component: Component) {
        for (behavior in behaviors) {
            behavior.bind(component)
        }
    }

    override fun detach(component: Component) {
        for (behavior in behaviors) {
            behavior.detach(component)
        }
    }

    override fun getStatelessHint(component: Component): Boolean {
        var stateless = true
        for (behavior in behaviors) {
            stateless = stateless && behavior.getStatelessHint(component)
        }
        return stateless
    }

    override fun isEnabled(component: Component): Boolean {
        var enabled = true
        for (behavior in behaviors) {
            enabled = enabled && behavior.isEnabled(component)
        }
        return enabled
    }

    override fun isTemporary(component: Component): Boolean {
        var back = true
        for (behavior in behaviors) {
            back = back && behavior.isTemporary(component)
        }
        return back
    }

    override fun onComponentTag(component: Component, tag: ComponentTag) {
        for (behavior in behaviors) {
            behavior.onComponentTag(component, tag)
        }
    }

    override fun renderHead(component: Component, response: IHeaderResponse) {
        super.renderHead(component, response)
        for (behavior in behaviors) {
            behavior.renderHead(component, response)
        }
    }

    override fun onException(component: Component, exception: RuntimeException) {
        for (behavior in behaviors) {
            behavior.onException(component, exception)
        }
    }

    fun addBehavior(behavior: Behavior) {
        behaviors.add(behavior)
    }
}