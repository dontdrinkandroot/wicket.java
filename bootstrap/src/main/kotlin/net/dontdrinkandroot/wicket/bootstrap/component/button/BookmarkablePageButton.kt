package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.Page
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * @param <T> Type of the model object.
 */
open class BookmarkablePageButton<T>(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    pageClass: Class<out Page>,
    pageParameters: PageParameters? = null,
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.SECONDARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null),
    vararg behaviors: Behavior,
) : BookmarkablePageLink<T>(id, pageClass, pageParameters) {

    init {
        body = bodyModel
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
        add(*behaviors)
    }
}