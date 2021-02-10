package net.dontdrinkandroot.wicket.bootstrap.component.item

import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel

abstract class LinkItem<T>(id: String, model: IModel<T>? = null, labelModel: IModel<String>) :
    AbstractLinkItem<T, Link<T>>(id, model, labelModel) {

    override fun createLink(id: String): Link<T> {
        return object : Link<T>(id, this.model) {
            override fun onClick() {
                this@LinkItem.onClick()
            }
        }
    }

    protected abstract fun onClick()
}