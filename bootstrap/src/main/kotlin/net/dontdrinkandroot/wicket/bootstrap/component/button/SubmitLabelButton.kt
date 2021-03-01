package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class SubmitLabelButton(
    id: String,
    model: IModel<*>? = null,
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.PRIMARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : Label(id, model) {

    init {
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
    }

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "button"
        tag.put("type", "submit")
        super.onComponentTag(tag)
    }
}