package net.dontdrinkandroot.wicket.bootstrap.component.panel

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.PanelBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle
import net.dontdrinkandroot.wicket.model.KModel
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the Model Object.
 */
abstract class Panel<T> @JvmOverloads constructor(id: String, model: IModel<T>? = null) : GenericPanel<T>(id, model) {

    private val panelBehavior = PanelBehavior(createStyleModel())

    protected lateinit var heading: Component

    protected lateinit var footer: Component

    protected lateinit var afterBody: Component

    override fun onInitialize() {
        super.onInitialize()
        this.add(panelBehavior)
        heading = createHeading(HEADING_ID)
        heading.add(CssClassAppender(BootstrapCssClass.PANEL_HEADING))
        this.add(heading)
        afterBody = createAfterBody(AFTER_BODY_ID)
        this.add(afterBody)
        footer = createFooter(FOOTER_ID)
        footer.add(CssClassAppender(BootstrapCssClass.PANEL_FOOTER))
        this.add(footer)
    }

    fun setPanelStyle(style: PanelStyle?): Panel<T> {
        panelBehavior.setStyle(style!!)
        return this
    }

    val panelStyle: PanelStyle
        get() = panelBehavior.getStyle()

    protected open fun createHeading(id: String): Component {
        val headingContainer = WebMarkupContainer(id)
        headingContainer.isVisible = false
        return headingContainer
    }

    protected open fun createAfterBody(id: String): Component {
        val afterBodyContainer = WebMarkupContainer(id)
        afterBodyContainer.isVisible = false
        return afterBodyContainer
    }

    protected fun createFooter(id: String): Component {
        val footerContainer = WebMarkupContainer(id)
        footerContainer.isVisible = false
        return footerContainer
    }

    protected fun createStyleModel(): KModel<PanelStyle> {
        return KModel { PanelStyle.DEFAULT }
    }

    companion object {

        const val BODY_ID = "body"
        const val HEADING_ID = "heading"
        const val FOOTER_ID = "footer"
        const val AFTER_BODY_ID = "afterBody"
    }
}