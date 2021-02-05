/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
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
                    val left: Column<Void> = object : Column<Void>(columnView.newChildId())
                    {
                        override fun createContent(id: String): Component
                        {
                            val label = Label(id, Model.of(columnSize.classString))
                            label.add(CssClassAppender(BackgroundColor.INFO))
                            return label
                        }
                    }
                    left.setSize(columnSize)
                    left.add(CssClassAppender(TextAlignment.CENTER))
                    columnView.add(left)
                    val right: Column<Void> = object : Column<Void>(columnView.newChildId())
                    {
                        override fun createContent(id: String): Component
                        {
                            val label = Label(
                                id,
                                Model.of(inverseColumnSize?.classString)
                            )
                            label.add(CssClassAppender(BackgroundColor.INFO))
                            return label
                        }
                    }
                    right.setSize(inverseColumnSize)
                    right.add(CssClassAppender(TextAlignment.CENTER))
                    columnView.add(right)
                }
            }
            row.add(StyleAppender("margin-bottom: 5px"))
            rowView.add(row)
        }
    }
}