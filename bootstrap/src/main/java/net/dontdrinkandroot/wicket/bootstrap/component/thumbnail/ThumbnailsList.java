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
package net.dontdrinkandroot.wicket.bootstrap.component.thumbnail;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize;
import net.dontdrinkandroot.wicket.model.ListItemModel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

import java.util.List;


public abstract class ThumbnailsList<T> extends GenericPanel<List<T>> {

    private final RepeatingView itemView;

    private final ColumnSize spanClass;

    public ThumbnailsList(String id, IModel<List<T>> model, final ColumnSize spanClass)
    {

        super(id, model);

        this.add(new CssClassAppender(BootstrapCssClass.THUMBNAILS));

        this.spanClass = spanClass;

        this.itemView = new RepeatingView("item");
        this.add(this.itemView);
    }

    @Override
    protected void onBeforeRender()
    {

        this.itemView.removeAll();

        for (int idx = 0; idx < this.getModelObject().size(); idx++) {
            IModel<T> listItemModel = new ListItemModel<T>(this.getModel(), idx);
            Component item = this.createItem(this.itemView.newChildId(), listItemModel);
            item.add(new CssClassAppender(this.spanClass));
            this.itemView.add(item);
        }

        super.onBeforeRender();
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {

        super.onComponentTag(tag);

        this.checkComponentTag(tag, "ul");
    }

    protected abstract Component createItem(String id, IModel<T> model);

}
