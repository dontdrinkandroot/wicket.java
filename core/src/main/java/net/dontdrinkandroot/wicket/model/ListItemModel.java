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
package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ListItemModel<T> implements IModel<T>
{
    private final IModel<List<T>> listModel;

    private final int idx;

    public ListItemModel(IModel<List<T>> model, int idx)
    {
        this.listModel = model;
        this.idx = idx;
    }

    @Override
    public void detach()
    {
        /* Noop, depends on parent */
    }

    @Override
    public T getObject()
    {
        return this.listModel.getObject().get(this.idx);
    }

    @Override
    public void setObject(T object)
    {
        List<T> list = this.listModel.getObject();
        list.set(this.idx, object);
    }
}
