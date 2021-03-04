package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

inline fun <T> buttonLink(
    id: String,
    model: IModel<T>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.SECONDARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null),
    crossinline onClickHandler: Link<T>.() -> Any?
) = object : Link<T>(id, model) {
    init {
        body = bodyModel
        behaviors.forEach { this.add(it) }
        this.add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
    }

    override fun onClick() {
        onClickHandler()
    }
}

inline fun buttonLink(
    id: String,
    bodyModel: IModel<String> = Model(null),
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.SECONDARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null),
    vararg behaviors: Behavior,
    crossinline onClickHandler: Link<Void>.() -> Any?
) = object : Link<Void>(id) {
    init {
        body = bodyModel
        behaviors.forEach { this.add(it) }
        this.add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
    }

    override fun onClick() {
        onClickHandler()
    }
}