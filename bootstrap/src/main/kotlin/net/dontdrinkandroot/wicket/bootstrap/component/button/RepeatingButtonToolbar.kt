package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object.
 */
abstract class RepeatingButtonToolbar<T>(id: String, model: IModel<T>? = null) : GenericPanel<T>(id, model) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.BTN_TOOLBAR))
        val buttonGroupView = RepeatingView("buttonGroup")
        populateButtonGroups(buttonGroupView)
        this.add(buttonGroupView)
    }

    protected abstract fun populateButtonGroups(buttonGroupView: RepeatingView)
}