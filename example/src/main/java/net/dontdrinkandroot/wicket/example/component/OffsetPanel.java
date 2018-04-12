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
package net.dontdrinkandroot.wicket.example.component;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.behavior.StyleAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.grid.Column;
import net.dontdrinkandroot.wicket.bootstrap.component.grid.RepeatingRow;
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor;
import net.dontdrinkandroot.wicket.bootstrap.css.TextAlignment;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffset;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.AbstractReadOnlyModel;

public class OffsetPanel extends GenericPanel<Void>
{
    private ColumnOffset[] columnOffsets;

    public OffsetPanel(String id, ColumnOffset[] columnOffsets)
    {
        super(id);
        this.columnOffsets = columnOffsets;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RepeatingView rowView = new RepeatingView("row");
        this.add(rowView);

        for (ColumnOffset columnOffset : this.columnOffsets) {
            ColumnSize inverseColumnSize = columnOffset.getInverseColumnSize();
            RepeatingRow row = new RepeatingRow(rowView.newChildId())
            {
                @Override
                protected void populateColumns(RepeatingView columnView)
                {
                    Column<Void> column = new Column<Void>(columnView.newChildId())
                    {
                        @Override
                        protected Component createContent(String id)
                        {
                            Label label = new Label(id, new AbstractReadOnlyModel<String>()
                            {
                                @Override
                                public String getObject()
                                {
                                    return columnOffset.getClassString() + " " + inverseColumnSize.getClassString();
                                }
                            });
                            label.add(new CssClassAppender(BackgroundColor.INFO));
                            return label;
                        }
                    };
                    column.setOffset(columnOffset);
                    column.setSize(inverseColumnSize);
                    column.add(new CssClassAppender(TextAlignment.CENTER));
                    columnView.add(column);
                }
            };
            row.add(new StyleAppender("margin-bottom: 5px"));
            rowView.add(row);
        }
    }
}
