package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.behavior.active
import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.kmodel.model
import org.apache.wicket.Page
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

open class BookmarkablePageLinkItem<T>(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    prependIconModel: IModel<CssClass> = Model(null),
    appendIconModel: IModel<CssClass> = Model(null),
    private val pageClass: Class<out Page>,
    private val pageParameters: PageParameters? = null
) : AbstractLinkItem<T, BookmarkablePageLink<T>>(id, model, labelModel, prependIconModel, appendIconModel) {

    override fun createLink(id: String): BookmarkablePageLink<T> {
        val link: BookmarkablePageLink<T> = object : BookmarkablePageLink<T>(id, pageClass) {
            override fun getPageParameters(): PageParameters {
                var parameters = this@BookmarkablePageLinkItem.pageParameters
                if (null == parameters) {
                    parameters = PageParameters()
                }
                return parameters
            }
        }
        link.model = model
        link.add(active { this.page.javaClass.isAssignableFrom(link.pageClass) })
        return link
    }
}

fun ItemView.pageLink(label: String, pageClass: Class<out Page>) {
    add(BookmarkablePageLinkItem<Void>(newChildId(), labelModel = model(label), pageClass = pageClass))
}

fun ItemView.pageLink(label: IModel<String>, pageClass: Class<out Page>) {
    add(BookmarkablePageLinkItem<Void>(newChildId(), labelModel = label, pageClass = pageClass))
}