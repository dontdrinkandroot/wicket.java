package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.MarkupContainer
import org.apache.wicket.Page
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

fun createPageLink(
    id: String,
    pageClass: Class<out Page>,
    pageParameters: PageParameters? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior
) = object : BookmarkablePageLink<Void>(id, pageClass, pageParameters) {
    init {
        body = label
        add(*behaviors)
    }
}

fun MarkupContainer.pageLink(
    id: String,
    pageClass: Class<out Page>,
    pageParameters: PageParameters? = null,
    label: IModel<String> = Model(null),
    vararg behaviors: Behavior
) {
    add(createPageLink(id, pageClass, pageParameters, label, *behaviors))
}