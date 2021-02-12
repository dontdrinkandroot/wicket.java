package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 */
abstract class ButtonLink<T>(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.SECONDARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null),
) : Link<T>(id, model) {

    protected var buttonBehavior = ButtonBehavior(buttonStyleModel, buttonSizeModel)

    init {
        body = bodyModel
    }

    override fun onInitialize() {
        super.onInitialize()
        this.add(buttonBehavior)
    }
}