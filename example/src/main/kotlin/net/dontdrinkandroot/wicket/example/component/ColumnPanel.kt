package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.StyleAppender
import net.dontdrinkandroot.wicket.bootstrap.component.grid.Column
import net.dontdrinkandroot.wicket.bootstrap.component.grid.RepeatingRow
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor
import net.dontdrinkandroot.wicket.bootstrap.css.TextAlignment
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model

class ColumnPanel(id: String, private val values: Array<out ColumnSize>) : GenericPanel<ColumnSize?>(id)
{
    override fun onInitialize()
    {
        super.onInitialize()
        val rowView = RepeatingView("row")
        this.add(rowView)
        for (columnSize in values)
        {
            val row: RepeatingRow = object : RepeatingRow(rowView.newChildId())
            {
                override fun populateColumns(columnView: RepeatingView)
                {
                    val inverseColumnSize = columnSize.inverseColumnSize
                    val left: Column<Void> =
                        object : Column<Void>(columnView.newChildId(), sizeModel = Model(columnSize)) {
                            override fun createContent(id: String): Component {
                                val label = Label(id, Model.of(columnSize.classString))
                                label.add(CssClassAppender(BackgroundColor.INFO))
                                return label
                            }
                        }
                    left.add(CssClassAppender(TextAlignment.CENTER))
                    columnView.add(left)
                    val right: Column<Void> =
                        object : Column<Void>(columnView.newChildId(), sizeModel = Model(inverseColumnSize)) {
                            override fun createContent(id: String): Component {
                                val label = Label(
                                    id,
                                    Model.of(inverseColumnSize?.classString)
                                )
                                label.add(CssClassAppender(BackgroundColor.INFO))
                                return label
                            }
                        }
                    right.add(CssClassAppender(TextAlignment.CENTER))
                    columnView.add(right)
                }
            }
            row.add(StyleAppender("margin-bottom: 5px"))
            rowView.add(row)
        }
    }
}