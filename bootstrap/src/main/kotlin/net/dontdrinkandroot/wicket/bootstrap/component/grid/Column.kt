package net.dontdrinkandroot.wicket.bootstrap.component.grid

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffset
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.kModel
import org.apache.wicket.Component
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

abstract class Column<T>(
    id: String,
    model: IModel<T>? = null,
    private var sizeModel: KModel<ColumnSize?> = null.kModel(),
    private var offsetModel: KModel<ColumnOffset?> = null.kModel()
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