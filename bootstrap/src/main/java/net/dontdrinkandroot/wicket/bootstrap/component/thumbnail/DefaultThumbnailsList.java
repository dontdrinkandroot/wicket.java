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

import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.model.IModel;

import java.util.List;


public abstract class DefaultThumbnailsList<T> extends ThumbnailsList<T> {

    public DefaultThumbnailsList(String id, IModel<List<T>> model, ColumnSize spanClass)
    {

        super(id, model, spanClass);
    }

    @Override
    protected Component createItem(String id, IModel<T> model)
    {

        return new DefaultThumbnail<T>(id, model)
        {

            @Override
            protected MarkupContainer createLink(String id, IModel<T> model)
            {

                return DefaultThumbnailsList.this.createLink(id, model);
            }

            @Override
            protected Component createImage(String id, IModel<T> model)
            {

                return DefaultThumbnailsList.this.createImage(id, model);
            }
        };
    }

    protected abstract MarkupContainer createLink(String id, IModel<T> model);

    protected abstract Component createImage(String id, IModel<T> model);
}
