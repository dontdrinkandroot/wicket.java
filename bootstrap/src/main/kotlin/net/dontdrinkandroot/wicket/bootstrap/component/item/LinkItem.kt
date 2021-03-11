package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.kmodel.model
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

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

fun ItemView.link(label: String, vararg linkBehaviors: Behavior, onClickHandler: LinkItem<Void>.() -> Any?) {
    add(object : LinkItem<Void>(newChildId(), null, model(label), linkBehaviors = linkBehaviors) {
        override fun onClick() {
            onClickHandler()
        }
    })
}

fun <T> ItemView.link(
    label: IModel<String>,
    model: IModel<T>,
    vararg linkBehaviors: Behavior,
    onClickHandler: LinkItem<T>.() -> Any?
) {
    add(object : LinkItem<T>(newChildId(), model, label, linkBehaviors = linkBehaviors) {
        override fun onClick() {
            onClickHandler()
        }
    })
}

inline fun <T> ItemView.link(
    label: String,
    model: IModel<T>,
    vararg linkBehaviors: Behavior,
    crossinline onClickHandler: LinkItem<T>.() -> Any?
) {
    add(createLinkItem(newChildId(), model, Model(label), linkBehaviors = *linkBehaviors, onClickHandler))
}