package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonLink
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment
import net.dontdrinkandroot.wicket.markup.html.link.Link
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class NavbarButton<T>(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    onClickHandler: (context: Link<T>) -> Any?,
    alignmentModel: IModel<NavbarAlignment> = NavbarAlignment.LEFT.model()
) : ButtonLink<T>(id, model, bodyModel, onClickHandler) {

    init {
        this.add(CssClassAppender(BootstrapCssClass.NAVBAR_BTN))
        this.add(CssClassAppender(alignmentModel))
    }
}