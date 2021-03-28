package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.MarkupContainer
import org.apache.wicket.Page
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters
import kotlin.reflect.KClass

class BookmarkablePageLink(
    id: String,
    pageClass: KClass<out Page>,
    pageParameters: PageParameters? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior
) : BookmarkablePageLink<Void>(id, pageClass.java, pageParameters) {

    init {
        body = label
        add(*behaviors)
    }
}

inline fun pageLink(
    id: String,
    pageClass: KClass<out Page>,
    pageParameters: PageParameters? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior
) = BookmarkablePageLink(id, pageClass, pageParameters, label, *behaviors)

inline fun MarkupContainer.addPageLink(
    id: String,
    pageClass: KClass<out Page>,
    pageParameters: PageParameters? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior
): net.dontdrinkandroot.wicket.markup.html.link.BookmarkablePageLink {
    val pageLink = pageLink(id, pageClass, pageParameters, label, *behaviors)
    add(pageLink)
    return pageLink
}