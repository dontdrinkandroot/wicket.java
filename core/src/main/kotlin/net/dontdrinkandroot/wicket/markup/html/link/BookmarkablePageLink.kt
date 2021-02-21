package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.Page
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

open class BookmarkablePageLink<T>(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    behaviors: List<Behavior> = emptyList(),
    pageClass: Class<out Page>,
    pageParameters: PageParameters? = null
) : BookmarkablePageLink<T>(id, pageClass, pageParameters) {

    init {
        this.model = model
        body = bodyModel
        behaviors.forEach { add(it) }
    }
}