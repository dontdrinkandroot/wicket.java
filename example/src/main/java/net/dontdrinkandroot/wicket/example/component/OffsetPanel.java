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

import java.util.Arrays;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffset;


public class OffsetPanel extends GenericPanel<Void>
{

	private ColumnOffset[] values;


	public OffsetPanel(String id, ColumnOffset[] values)
	{
		super(id);
		this.values = values;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		ListView<ColumnOffset> row = new ListView<ColumnOffset>("row", Arrays.asList(this.values)) {

			@Override
			protected void populateItem(ListItem<ColumnOffset> item)
			{
				ColumnOffset columnOffset = item.getModelObject();

				WebMarkupContainer container = new WebMarkupContainer("container");
				container.add(new CssClassAppender(columnOffset));
				container.add(new CssClassAppender(columnOffset.getInverseColumnSize()));
				item.add(container);

				Label offsetLabel = new Label("offsetLabel", Model.of(columnOffset.getClassString()));
				container.add(offsetLabel);

				Label columnLabel =
						new Label("columnLabel", Model.of(columnOffset.getInverseColumnSize().getClassString()));
				container.add(columnLabel);
			}
		};
		this.add(row);
	}

}
