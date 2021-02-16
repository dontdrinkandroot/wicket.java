package net.dontdrinkandroot.wicket.bootstrap.component.card

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the Model Object.
 */
abstract class Card<T> constructor(
    id: String,
    model: IModel<T>? = null,
) : GenericPanel<T>(id, model) {

    val BODY_ID = "body"
    val HEADER_ID = "header"
    val FOOTER_ID = "footer"
    val AFTER_BODY_ID = "afterBody"

    protected lateinit var header: Component

    protected lateinit var footer: Component

    protected lateinit var afterBody: Component

    override fun onInitialize() {
        super.onInitialize()
        add(CssClassAppender(BootstrapCssClass.CARD))

        header = createHeader(HEADER_ID)
        header.add(CssClassAppender(BootstrapCssClass.CARD_HEADER))
        this.add(header)

        afterBody = createAfterBody(AFTER_BODY_ID)
        this.add(afterBody)

        footer = createFooter(FOOTER_ID)
        footer.add(CssClassAppender(BootstrapCssClass.CARD_FOOTER))
        this.add(footer)
    }

    protected open fun createHeader(id: String): Component {
        val headingContainer = WebMarkupContainer(id)
        headingContainer.isVisible = false
        return headingContainer
    }

    protected open fun createAfterBody(id: String): Component {
        val afterBodyContainer = WebMarkupContainer(id)
        afterBodyContainer.isVisible = false
        return afterBodyContainer
    }

    protected open fun createFooter(id: String): Component {
        val footerContainer = WebMarkupContainer(id)
        footerContainer.isVisible = false
        return footerContainer
    }
}