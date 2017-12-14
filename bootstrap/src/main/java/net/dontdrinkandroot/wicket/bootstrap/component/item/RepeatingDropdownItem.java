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
package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

/**
 * {@link DropdownItem} that is populated via a {@link RepeatingView}.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class RepeatingDropdownItem<T> extends DropdownItem<T>
{
    public RepeatingDropdownItem(String id, IModel<String> labelModel)
    {
        this(id, labelModel, null);
    }

    public RepeatingDropdownItem(String id, IModel<String> labelModel, IModel<T> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected DropdownMenu createDropdownMenu(String id)
    {
        return new DropdownMenu(id)
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                RepeatingDropdownItem.this.populateItems(itemView);
            }
        };
    }

    protected abstract void populateItems(RepeatingView itemView);
}
