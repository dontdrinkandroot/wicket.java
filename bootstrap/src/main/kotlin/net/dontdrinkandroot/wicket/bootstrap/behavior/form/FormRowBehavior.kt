package net.dontdrinkandroot.wicket.bootstrap.behavior.form

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.util.BehaviorUtils
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

class FormRowBehavior : Behavior() {

    override fun bind(component: Component) {
        super.bind(component)
        component.add(CssClassAppender(IModel<CssClass> {
            val formStyleBehavior = BehaviorUtils.findClosestBehavior(component, FormStyleBehavior::class.java)
            if (null != formStyleBehavior && formStyleBehavior.isHorizontal) BootstrapCssClass.ROW
            null
        }))
    }
}