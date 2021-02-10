package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class LinkItem<T>(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    prependIconModel: IModel<CssClass> = Model(null),
    appendIconModel: IModel<CssClass> = Model(null)
) : AbstractLinkItem<T, Link<T>>(id, model, labelModel, prependIconModel, appendIconModel) {

    override fun createLink(id: String): Link<T> {
        return object : Link<T>(id, this.model) {
            override fun onClick() {
                this@LinkItem.onClick()
            }
        }
    }

    protected abstract fun onClick()
}