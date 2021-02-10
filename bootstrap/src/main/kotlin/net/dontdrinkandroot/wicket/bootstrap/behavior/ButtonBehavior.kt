package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.button.IButton
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Component
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.form.AbstractSubmitLink
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class ButtonBehavior constructor(
    private var buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    private var buttonSizeModel: IModel<ButtonSize> = Model(null)
) : CompositeBehavior(CssClassAppender(BootstrapCssClass.BTN), DisabledCssBehavior()), IButton {

    constructor(buttonStyle: ButtonStyle) : this(buttonStyleModel = buttonStyle.model())

    constructor(buttonSize: ButtonSize) : this(buttonSizeModel = buttonSize.model())

    constructor(buttonStyle: ButtonStyle, buttonSize: ButtonSize) : this(buttonStyle.model(), buttonSize.model())

    override fun getButtonSize() = buttonSizeModel.getObject()

    override fun setButtonSize(buttonSize: ButtonSize?): ButtonBehavior {
        buttonSizeModel.setObject(buttonSize)
        return this
    }

    override fun getButtonStyle(): ButtonStyle = buttonStyleModel.getObject()

    override fun setButtonStyle(buttonStyle: ButtonStyle): ButtonBehavior {
        buttonStyleModel.setObject(buttonStyle)
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

    override fun setButtonSizeModel(buttonSizeModel: IModel<ButtonSize>): ButtonBehavior {
        this.buttonSizeModel = buttonSizeModel
        return this
    }

    override fun setButtonStyleModel(buttonStyleModel: IModel<ButtonStyle>): ButtonBehavior {
        this.buttonStyleModel = buttonStyleModel
        return this
    }

    init {
        addBehavior(CssClassAppender(buttonStyleModel))
        addBehavior(CssClassAppender(buttonSizeModel))
    }
}