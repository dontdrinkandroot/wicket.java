package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.button.Button
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.kModel
import org.apache.wicket.model.IModel

abstract class NavbarButton<T>(
    id: String,
    model: IModel<T>?,
    alignmentModel: KModel<NavbarAlignment> = NavbarAlignment.LEFT.kModel()
) : Button<T>(id, model) {

    init {
        this.add(CssClassAppender(BootstrapCssClass.NAVBAR_BTN))
        this.add(CssClassAppender(alignmentModel))
    }
}