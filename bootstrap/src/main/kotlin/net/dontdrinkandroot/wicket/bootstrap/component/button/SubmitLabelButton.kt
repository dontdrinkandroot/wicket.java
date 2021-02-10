package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel
import java.io.Serializable

class SubmitLabelButton : Label, IButton {

    protected var buttonBehavior = ButtonBehavior(ButtonStyle.PRIMARY)

    constructor(id: String) : super(id)
    constructor(id: String, label: Serializable?) : super(id, label)
    constructor(id: String, model: IModel<*>?) : super(id, model)

    override fun onInitialize() {
        super.onInitialize()
        add(buttonBehavior)
    }

    override fun setButtonStyle(buttonStyle: ButtonStyle): SubmitLabelButton {
        buttonBehavior.setButtonStyle(buttonStyle)
        return this
    }

    override fun setButtonSize(buttonSize: ButtonSize?): SubmitLabelButton {
        buttonBehavior.setButtonSize(buttonSize)
        return this
    }

    override fun getButtonSize(): ButtonSize? {
        return buttonBehavior.getButtonSize()
    }

    override fun getButtonStyle(): ButtonStyle {
        return buttonBehavior.getButtonStyle()
    }

    override fun setButtonSizeModel(buttonSizeModel: IModel<ButtonSize>): SubmitLabelButton {
        buttonBehavior.setButtonSizeModel(buttonSizeModel)
        return this
    }

    override fun setButtonStyleModel(buttonStyleModel: IModel<ButtonStyle>): SubmitLabelButton {
        buttonBehavior.setButtonStyleModel(buttonStyleModel)
        return this
    }

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "button"
        tag.put("type", "submit")
        super.onComponentTag(tag)
    }
}