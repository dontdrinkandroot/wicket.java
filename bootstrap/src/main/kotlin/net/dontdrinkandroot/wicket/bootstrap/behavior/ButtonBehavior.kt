package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.button.IButton
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.kModel
import org.apache.wicket.Component
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.form.AbstractSubmitLink
import org.apache.wicket.markup.html.link.AbstractLink

class ButtonBehavior constructor(
    private var buttonStyleModel: KModel<ButtonStyle> = ButtonStyle.SECONDARY.kModel(),
    private var buttonSizeModel: KModel<ButtonSize?> = null.kModel()
) : CompositeBehavior(CssClassAppender(BootstrapCssClass.BTN), DisabledCssBehavior()), IButton {

    constructor(buttonStyle: ButtonStyle) : this(buttonStyleModel = buttonStyle.kModel())

    constructor(buttonSize: ButtonSize) : this(buttonSizeModel = buttonSize.kModel())

    constructor(buttonStyle: ButtonStyle, buttonSize: ButtonSize) : this(buttonStyle.kModel(), buttonSize.kModel())

    override fun getButtonSize() = buttonSizeModel.getValue()

    override fun setButtonSize(buttonSize: ButtonSize?): ButtonBehavior {
        buttonSizeModel.setValue(buttonSize)
        return this
    }

    override fun getButtonStyle(): ButtonStyle = buttonStyleModel.getValue()

    override fun setButtonStyle(buttonStyle: ButtonStyle): ButtonBehavior {
        buttonStyleModel.setValue(buttonStyle)
        return this
    }

    override fun onComponentTag(component: Component, tag: ComponentTag) {
        super.onComponentTag(component, tag)

        /* Check if it is a button without a type and try to determine it */
        if (tag.name.equals("button", ignoreCase = true)) {
            if (null == tag.getAttribute("type")) {
                if (component is AbstractSubmitLink && component !is AjaxSubmitLink) {
                    tag.put("type", "submit")
                } else {
                    tag.put("type", "button")
                }
            }
        }

        /* If this is an input button set the bodyModel as its value attribute */
        if (tag.name.equals("input", ignoreCase = true) && component is AbstractLink
        ) {
            val bodyModel = component.body
            if (bodyModel?.getObject() != null) {
                tag.put("value", component.getDefaultModelObjectAsString(bodyModel.getObject()))
            }
        }
    }

    override fun setButtonSizeModel(buttonSizeModel: KModel<ButtonSize?>): ButtonBehavior {
        this.buttonSizeModel = buttonSizeModel
        return this
    }

    override fun setButtonStyleModel(buttonStyleModel: KModel<ButtonStyle>): ButtonBehavior {
        this.buttonStyleModel = buttonStyleModel
        return this
    }

    init {
        addBehavior(CssClassAppender(buttonStyleModel))
        addBehavior(CssClassAppender(buttonSizeModel))
    }
}