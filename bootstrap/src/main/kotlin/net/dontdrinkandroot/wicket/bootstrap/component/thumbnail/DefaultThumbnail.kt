package net.dontdrinkandroot.wicket.bootstrap.component.thumbnail

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.Component
import org.apache.wicket.MarkupContainer
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

abstract class DefaultThumbnail<T>(id: String?, model: IModel<T>?) : GenericPanel<T>(id, model) {

    override fun onInitialize() {
        super.onInitialize()
        val link = createLink("link", model)
        link.add(CssClassAppender(BootstrapCssClass.THUMBNAIL))
        this.add(link)
        val image = createImage("image", model)
        link.add(image)
    }

    protected abstract fun createLink(id: String, model: IModel<T>): MarkupContainer

    protected abstract fun createImage(id: String, model: IModel<T>): Component
}