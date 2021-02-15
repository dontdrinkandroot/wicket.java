package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Page
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * @param <T> Type of the model object.
 */
open class BookmarkablePageButton<T, C : Page>(
    id: String,
    pageClass: Class<out C>,
    parameters: PageParameters = PageParameters(),
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : BookmarkablePageLink<T>(id, pageClass, parameters) {

    init {
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
    }
}