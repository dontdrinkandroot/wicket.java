package net.dontdrinkandroot.wicket.bootstrap.component.item

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

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

inline fun <T> ajaxLinkItem(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String>,
    vararg linkBehaviors: Behavior,
    crossinline onClickHandler: AjaxLinkItem<T>.(target: AjaxRequestTarget?) -> Any?
) = object : AjaxLinkItem<T>(
    id,
    model,
    label,
    linkBehaviors = linkBehaviors
) {
    override fun onClick(target: AjaxRequestTarget?) {
        onClickHandler(target)
    }
}

inline fun ItemView.addAjaxLink(
    label: String,
    vararg linkBehaviors: Behavior,
    crossinline onClickHandler: AjaxLinkItem<Void>.(target: AjaxRequestTarget?) -> Any?
): AjaxLinkItem<Void> {
    val linkItem = ajaxLinkItem(newChildId(), null, Model(label), linkBehaviors = linkBehaviors, onClickHandler)
    add(linkItem)
    return linkItem
}

inline fun <T> ItemView.addAjaxLink(
    label: String,
    model: IModel<T>,
    vararg linkBehaviors: Behavior,
    crossinline onClickHandler: AjaxLinkItem<T>.(target: AjaxRequestTarget?) -> Any?
): AjaxLinkItem<T> {
    val linkItem = ajaxLinkItem(newChildId(), model, Model(label), linkBehaviors = linkBehaviors, onClickHandler)
    add(linkItem)
    return linkItem
}

