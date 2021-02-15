package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.markup.html.link.Link
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 */
open class ButtonLink<T>(
    id: String,
    model: IModel<T>? = null,
    visibleModel: IModel<Boolean> = Model(true),
    enabledModel: IModel<Boolean> = Model(true),
    behaviors: Collection<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    onClickHandler: (context: Link<T>) -> Any?,
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.SECONDARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : Link<T>(id, model, visibleModel, enabledModel, behaviors, bodyModel, onClickHandler) {

    protected var buttonBehavior = ButtonBehavior(buttonStyleModel, buttonSizeModel)

    override fun onInitialize() {
        super.onInitialize()
        this.add(buttonBehavior)
    }
}