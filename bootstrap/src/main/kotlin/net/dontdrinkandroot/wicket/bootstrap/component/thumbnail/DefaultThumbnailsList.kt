package net.dontdrinkandroot.wicket.bootstrap.component.thumbnail

import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize
import org.apache.wicket.Component
import org.apache.wicket.MarkupContainer
import org.apache.wicket.model.IModel

abstract class DefaultThumbnailsList<T>(id: String, model: IModel<List<T>>? = null, spanClass: ColumnSize? = null) :
    ThumbnailsList<T>(id, model, spanClass) {

    override fun createItem(id: String, model: IModel<T>): Component {
        return object : DefaultThumbnail<T>(id, model) {
            override fun createLink(id: String, model: IModel<T>): MarkupContainer {
                return this@DefaultThumbnailsList.createLink(id, model)
            }

            override fun createImage(id: String, model: IModel<T>): Component {
                return this@DefaultThumbnailsList.createImage(id, model)
            }
        }
    }

    protected abstract fun createLink(id: String, model: IModel<T>): MarkupContainer

    protected abstract fun createImage(id: String, model: IModel<T>): Component
}