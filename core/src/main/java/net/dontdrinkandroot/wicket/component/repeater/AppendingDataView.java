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
package net.dontdrinkandroot.wicket.component.repeater;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

import java.util.Iterator;


public abstract class AppendingDataView<T> extends DataView<T> {

    private final String itemTagName;

    protected AppendingDataView(String id, IDataProvider<T> dataProvider, String itemTagName, long itemsPerPage)
    {

        super(id, dataProvider, itemsPerPage);
        this.itemTagName = itemTagName;
    }

    public void appendNewItems(AjaxRequestTarget target, Component parent)
    {

        Iterator<IModel<T>> models = this.getItemModels();
        Iterator<Item<T>> items = this.getItemReuseStrategy().getItems(this.newItemFactory(), models, this.getItems());

        int index = (int) this.getFirstItemOffset();
        while (items.hasNext()) {

            Item<T> item = items.next();
            item.setOutputMarkupId(true);
            item.setIndex(index);
            this.add(item);
            ++index;

            target.prependJavaScript(String.format(
                    "var item = document.createElement('%s'); item.id = '%s'; Wicket.$('%s').appendChild(item);",
                    this.itemTagName,
                    item.getMarkupId(),
                    parent.getMarkupId()
            ));
            target.add(item);
        }
    }

    @Override
    protected void onConfigure()
    {

        super.onConfigure();

        /*
         * Reset current page before rendering so that on a page reload or re-adding of the view we
         * start scrolling from the top again
         */
        this.setCurrentPage(0);
    }

}
