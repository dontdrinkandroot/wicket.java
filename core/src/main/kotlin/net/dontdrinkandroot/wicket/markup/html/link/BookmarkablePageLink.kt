package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.Page
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters
import kotlin.reflect.KClass
import org.apache.wicket.markup.html.link.BookmarkablePageLink as WicketBookmarkablePageLink

open class BookmarkablePageLink<T>(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    pageClass: Class<out Page>,
    pageParameters: PageParameters? = null,
    vararg behaviors: Behavior
) : WicketBookmarkablePageLink<T>(id, pageClass, pageParameters) {

    init {
        this.model = model
        body = bodyModel
        add(*behaviors)
    }
}

fun bookmarkablePageLink(
    id: String,
    pageClass: KClass<out Page>,
    pageParameters: PageParameters? = null,
    bodyModel: IModel<String> = Model(null),
    vararg behaviors: Behavior
) = BookmarkablePageLink<Void>(
    id,
    pageClass = pageClass.java,
    pageParameters = pageParameters,
    bodyModel = bodyModel,
    behaviors = behaviors
)