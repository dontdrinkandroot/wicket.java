package net.dontdrinkandroot.wicket.bootstrap.component.panel

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.IModel

/**
 * A [Panel] that has no default components. You need to overwrite the corresponding create methods.
 *
 * @param <T> Type of the Model Object.
 */
open class PlainPanel<T>(id: String, model: IModel<T>? = null) : Panel<T>(id, model) {

    protected lateinit var body: Component

    override fun onInitialize() {
        super.onInitialize()
        body = createBody(BODY_ID)
        body.add(CssClassAppender(BootstrapCssClass.PANEL_BODY))
        this.add(body)
    }

    protected open fun createBody(id: String): Component {
        val bodyContainer = WebMarkupContainer(id)
        bodyContainer.isVisible = false
        return bodyContainer
    }
}