package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Component
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 */
abstract class InputGroupButton<T>(
    id: String,
    model: IModel<T>? = null,
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : GenericPanel<T>(id, model) {

    private val buttonBehavior = ButtonBehavior(buttonStyleModel, buttonSizeModel)

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.INPUT_GROUP_BTN))
        val link = createLink("button")
        link.add(buttonBehavior)
        this.add(link)
    }

    protected abstract fun createLink(id: String): Component
}