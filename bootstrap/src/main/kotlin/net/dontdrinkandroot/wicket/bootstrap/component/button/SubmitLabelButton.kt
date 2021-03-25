package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.button
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.component.basic.SubmitButtonLabel
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

@Deprecated("Use SubmitButtonLabel with ButtonBehavior")
class SubmitLabelButton(
    id: String,
    model: IModel<*>? = null,
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.PRIMARY),
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

inline fun RepeatingView.addSubmitButton(
    label: String,
    buttonStyle: ButtonStyle? = ButtonStyle.PRIMARY,
    buttonSize: ButtonSize? = null
): SubmitButtonLabel {
    val submitButtonLabel = SubmitButtonLabel(newChildId(), Model(label), button(buttonStyle, buttonSize))
    add(submitButtonLabel)
    return submitButtonLabel
}