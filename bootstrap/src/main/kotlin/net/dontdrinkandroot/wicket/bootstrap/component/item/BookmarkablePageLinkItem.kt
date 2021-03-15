package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.kmodel.model
import org.apache.wicket.Page
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.model.IModel
import org.apache.wicket.request.mapper.parameter.PageParameters

open class BookmarkablePageLinkItem<T>(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String>,
    private val pageClass: Class<out Page>,
    private val pageParameters: PageParameters? = null,
    vararg linkBehaviors: Behavior
) : AbstractLinkItem<T, BookmarkablePageLink<T>>(id, model, label, emptyArray(), *linkBehaviors) {

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
//        link.add(active { this.page.javaClass.isAssignableFrom(link.pageClass) })
        return link
    }
}

fun ItemView.addPageLink(label: String, pageClass: Class<out Page>) {
    add(BookmarkablePageLinkItem<Void>(newChildId(), label = model(label), pageClass = pageClass))
}

fun ItemView.addPageLink(
    label: String,
    pageClass: Class<out Page>,
    pageParameters: PageParameters?,
    vararg linkBehaviors: Behavior
) {
    add(
        BookmarkablePageLinkItem<Void>(
            newChildId(),
            label = model(label),
            pageClass = pageClass,
            pageParameters = pageParameters,
            linkBehaviors = *linkBehaviors
        )
    )
}

fun ItemView.addPageLink(label: IModel<String>, pageClass: Class<out Page>) {
    add(BookmarkablePageLinkItem<Void>(newChildId(), label = label, pageClass = pageClass))
}