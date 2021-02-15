package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object.
 */
abstract class RepeatingButtonGroup<T>(id: String, model: IModel<T>? = null) : GenericPanel<T>(id, model) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.BTN_GROUP))
        val buttonView = RepeatingView("button")
        populateButtons(buttonView)
        this.add(buttonView)
    }

    protected abstract fun populateButtons(buttonView: RepeatingView?)
}