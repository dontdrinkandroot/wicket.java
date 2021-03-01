package net.dontdrinkandroot.wicket.bootstrap.component.modal

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the modal object.
 */
abstract class Modal<T>(id: String, model: IModel<T>? = null) : GenericPanel<T>(id, model) {

    override fun onInitialize() {
        super.onInitialize()
        this.outputMarkupId = true
        this.add(CssClassAppender(BootstrapCssClass.MODAL))
        this.add(CssClassAppender(BootstrapCssClass.FADE))
        val headingLabel = Label("heading", createHeadingModel())
        headingLabel.add(CssClassAppender(BootstrapCssClass.MODAL_TITLE))
        this.add(headingLabel)
        addFooter()
    }

    protected open fun addFooter() {
        val footer = createFooter("footer")
        footer.add(CssClassAppender(BootstrapCssClass.MODAL_FOOTER))
        this.add(footer)
    }

    protected open fun createFooter(id: String): Component {
        val footer = WebMarkupContainer(id)
        footer.isVisible = false
        return footer
    }

    val hideScript: CharSequence
        get() = "bootstrap.Modal.getInstance(document.getElementById('$markupId')).hide()"

    val showScript: CharSequence
        get() = "new bootstrap.Modal(document.getElementById('$markupId')).show()"

    protected abstract fun createHeadingModel(): IModel<String>
}