package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.Component
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.form.AbstractSubmitLink
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class ButtonBehavior constructor(
    buttonStyleModel: IModel<ButtonStyle> = Model(ButtonStyle.SECONDARY),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : CompositeBehavior(CssClassAppender(BootstrapCssClass.BTN), DisabledCssBehavior()) {

    constructor(buttonStyle: ButtonStyle?) : this(buttonStyleModel = Model(buttonStyle))

    constructor(buttonSize: ButtonSize?) : this(buttonSizeModel = Model(buttonSize))

    constructor(buttonStyle: ButtonStyle?, buttonSize: ButtonSize?) : this(Model(buttonStyle), Model(buttonSize))

    init {
        addBehavior(CssClassAppender(buttonStyleModel))
        addBehavior(CssClassAppender(buttonSizeModel))
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
}