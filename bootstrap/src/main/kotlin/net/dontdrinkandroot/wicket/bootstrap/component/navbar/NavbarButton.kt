package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.button.Button
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class NavbarButton<T>(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    alignmentModel: IModel<NavbarAlignment> = NavbarAlignment.LEFT.model()
) : Button<T>(id, model, behaviors, bodyModel) {

    init {
        this.add(CssClassAppender(BootstrapCssClass.NAVBAR_BTN))
        this.add(CssClassAppender(alignmentModel))
    }
}

fun <T> navbarButton(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    alignmentModel: IModel<NavbarAlignment> = NavbarAlignment.LEFT.model(),
    onClickHandler: NavbarButton<T>.() -> Any?
) = object : NavbarButton<T>(id, model, behaviors = behaviors, bodyModel = bodyModel, alignmentModel = alignmentModel) {
    override fun onClick() {
        onClickHandler()
    }
}