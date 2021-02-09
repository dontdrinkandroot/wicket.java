package net.dontdrinkandroot.wicket.bootstrap.component.grid

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffset
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize
import org.apache.wicket.Component
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class Column<T>(
    id: String,
    model: IModel<T>? = null,
    private var sizeModel: IModel<ColumnSize?> = Model(null),
    private var offsetModel: IModel<ColumnOffset?> = Model(null)
) : GenericPanel<T>(id, model) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(sizeModel))
        this.add(CssClassAppender(offsetModel))
        this.add(createContent("content"))
    }

    override fun detachModels() {
        super.detachModels()
        sizeModel.detach()
        offsetModel.detach()
    }

    protected abstract fun createContent(id: String): Component
}