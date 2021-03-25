package net.dontdrinkandroot.wicket.bootstrap.behavior.form

import findClosestBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior

class FormRowBehavior : Behavior() {

    override fun bind(component: Component) {
        super.bind(component)
        component.add(CssClassAppender {
            val formStyleBehavior = component.findClosestBehavior(FormStyleBehavior::class)
            if (null != formStyleBehavior && formStyleBehavior.horizontal)
                BootstrapCssClass.ROW
            else
                null
        })
    }
}