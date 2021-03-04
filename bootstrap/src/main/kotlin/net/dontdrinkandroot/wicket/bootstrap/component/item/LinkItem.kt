package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.kmodel.kModel
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class LinkItem<T>(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    prependIconModel: IModel<CssClass> = Model(null),
    appendIconModel: IModel<CssClass> = Model(null),
    vararg linkBehaviors: Behavior
) : AbstractLinkItem<T, Link<T>>(
    id,
    model,
    labelModel,
    prependIconModel,
    appendIconModel,
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

fun <T> linkItem(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    prependIconModel: IModel<CssClass> = Model(null),
    appendIconModel: IModel<CssClass> = Model(null),
    vararg linkBehaviors: Behavior,
    onClickHandler: LinkItem<T>.() -> Any?
) = object : LinkItem<T>(
    id,
    model,
    labelModel = labelModel,
    prependIconModel = prependIconModel,
    appendIconModel = appendIconModel,
    linkBehaviors = linkBehaviors
) {
    override fun onClick() {
        onClickHandler()
    }
}

fun ItemView.link(label: String, vararg linkBehaviors: Behavior, onClickHandler: LinkItem<Void>.() -> Any?) {
    this.add(object : LinkItem<Void>(this.newChildId(), null, kModel(label), linkBehaviors = linkBehaviors) {
        override fun onClick() {
            onClickHandler()
        }
    })
}