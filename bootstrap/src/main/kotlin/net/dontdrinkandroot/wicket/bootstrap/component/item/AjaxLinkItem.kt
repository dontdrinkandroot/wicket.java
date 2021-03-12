package net.dontdrinkandroot.wicket.bootstrap.component.item

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

abstract class AjaxLinkItem<T>(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String>,
    vararg linkBehaviors: Behavior
) : AbstractLinkItem<T, AjaxLink<T>>(id, model, label, linkBehaviors = linkBehaviors) {

    override fun createLink(id: String): AjaxLink<T> {
        return object : AjaxLink<T>(id, this.model) {
            override fun onClick(target: AjaxRequestTarget) {
                this@AjaxLinkItem.onClick(target)
            }
        }
    }

    protected abstract fun onClick(target: AjaxRequestTarget?)
}