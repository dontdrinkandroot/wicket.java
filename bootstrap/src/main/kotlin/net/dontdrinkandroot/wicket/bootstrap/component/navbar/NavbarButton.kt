package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

inline fun <T> NavbarButtonLink(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    alignmentModel: IModel<NavbarAlignment> = Model(NavbarAlignment.LEFT),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<T>.() -> Any?
) = object : Link<T>(id, model) {
    init {
        body = bodyModel
        this.add(CssClassAppender(BootstrapCssClass.NAVBAR_BTN))
        this.add(CssClassAppender(alignmentModel))
        add(*behaviors)
    }

    override fun onClick() {
        onClickHandler()
    }
}