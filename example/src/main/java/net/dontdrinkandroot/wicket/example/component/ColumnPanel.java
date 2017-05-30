/*
 * Copyright (C) 2012-2016 Philip Washington Sorst <philip@sorst.net>
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
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.Model;

import java.util.Arrays;

public class ColumnPanel extends GenericPanel<ColumnSize>
{
    private ColumnSize[] values;

    public ColumnPanel(String id, ColumnSize[] values)
    {
        super(id);
        this.values = values;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        ListView<ColumnSize> row = new ListView<ColumnSize>("row", Arrays.asList(this.values))
        {

            @Override
            protected void populateItem(ListItem<ColumnSize> item)
            {
                ColumnSize columnSize = item.getModelObject();
                WebMarkupContainer left = new WebMarkupContainer("left");
                this.add(left);
                Label leftLabel = new Label("label", Model.of(columnSize.getClassString()));
                left.add(leftLabel);
                left.add(new CssClassAppender(columnSize));
                item.add(left);

                ColumnSize inverseColumnSize = columnSize.getInverseColumnSize();
                WebMarkupContainer right = new WebMarkupContainer("right");
                this.add(right);
                Label rightLabel = new Label(
                        "label",
                        Model.of(null == inverseColumnSize ? null : inverseColumnSize.getClassString())
                );
                right.add(rightLabel);
                if (null != inverseColumnSize) {
                    right.add(new CssClassAppender(inverseColumnSize));
                }
                item.add(right);
            }
        };
        this.add(row);
    }
}
