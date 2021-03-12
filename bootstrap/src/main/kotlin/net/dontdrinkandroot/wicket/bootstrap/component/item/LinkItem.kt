package net.dontdrinkandroot.wicket.bootstrap.component.item

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel

abstract class LinkItem<T>(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    vararg linkBehaviors: Behavior
) : AbstractLinkItem<T, Link<T>>(
    id,
    model,
    labelModel,
    linkBehaviors = linkBehaviors
) {

    override fun createLink(id: String): Link<T> {
        val link = object : Link<T>(id, this.model) {
            override fun onClick() {
                this@LinkItem.onClick()
            }
        }
        return link
    }

    protected abstract fun onClick()
}

inline fun <T> createLinkItem(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String>,
    vararg linkBehaviors: Behavior,
    crossinline onClickHandler: LinkItem<T>.() -> Any?
) = object : LinkItem<T>(
    id,
    model,
    labelModel = label,
    linkBehaviors = linkBehaviors
) {
    override fun onClick() {
        onClickHandler()
    }
}