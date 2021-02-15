package net.dontdrinkandroot.wicket.bootstrap.component.item

import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.link.ExternalLink
import org.apache.wicket.model.IModel
import org.apache.wicket.request.UrlUtils

open class ExternalLinkItem(id: String, labelModel: IModel<String>, hrefModel: IModel<String>) :
    AbstractLinkItem<String, ExternalLink>(id, hrefModel, labelModel) {

    override fun createLink(id: String): ExternalLink {
        val link = ExternalLink(id, this.model)
        link.add(AttributeModifier("rel", IModel<Any> {
            when {
                UrlUtils.isRelative(this@ExternalLinkItem.modelObject) -> return@IModel null
                else -> return@IModel "external"
            }
        }))
        return link
    }
}