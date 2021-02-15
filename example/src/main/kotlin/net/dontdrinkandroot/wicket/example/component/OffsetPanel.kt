package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.StyleAppender
import net.dontdrinkandroot.wicket.bootstrap.component.grid.Column
import net.dontdrinkandroot.wicket.bootstrap.component.grid.RepeatingRow
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor
import net.dontdrinkandroot.wicket.bootstrap.css.TextAlignment
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffset
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class OffsetPanel(id: String, private val columnOffsets: Array<out ColumnOffset>) : GenericPanel<Void?>(id) {

    override fun onInitialize() {
        super.onInitialize()
        val rowView = RepeatingView("row")
        this.add(rowView)
        for (columnOffset in columnOffsets) {
            val inverseColumnSize = columnOffset.inverseColumnSize
            val row: RepeatingRow = object : RepeatingRow(rowView.newChildId()) {
                override fun populateColumns(columnView: RepeatingView) {
                    val column: Column<Void> = object : Column<Void>(
                        columnView.newChildId(),
                        sizeModel = Model(inverseColumnSize),
                        offsetModel = Model(columnOffset)
                    ) {
                        override fun createContent(id: String): Component {
                            val label = Label(
                                id,
                                IModel { columnOffset.classString + " " + inverseColumnSize.classString } as IModel<String>
                            )
                            label.add(CssClassAppender(BackgroundColor.INFO))
                            return label
                        }
                    }
                    column.add(CssClassAppender(TextAlignment.CENTER))
                    columnView.add(column)
                }
            }
            row.add(StyleAppender("margin-bottom: 5px"))
            rowView.add(row)
        }
    }
}