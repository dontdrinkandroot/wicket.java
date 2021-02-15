package net.dontdrinkandroot.wicket.bootstrap.component.thumbnail

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize
import net.dontdrinkandroot.wicket.model.ListItemModel
import org.apache.wicket.Component
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

abstract class ThumbnailsList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    private val spanClass: ColumnSize? = null
) : GenericPanel<List<T>>(id, model) {

    private val itemView: RepeatingView

    init {
        this.add(CssClassAppender(BootstrapCssClass.THUMBNAILS))
        itemView = RepeatingView("item")
        this.add(itemView)
    }

    override fun onBeforeRender() {
        itemView.removeAll()
        for (idx in this.modelObject!!.indices) {
            val listItemModel: IModel<T> = ListItemModel(model, idx)
            val item = createItem(itemView.newChildId(), listItemModel)
            item.add(CssClassAppender(spanClass!!))
            itemView.add(item)
        }
        super.onBeforeRender()
    }

    override fun onComponentTag(tag: ComponentTag) {
        super.onComponentTag(tag)
        checkComponentTag(tag, "ul")
    }

    protected abstract fun createItem(id: String, model: IModel<T>): Component
}