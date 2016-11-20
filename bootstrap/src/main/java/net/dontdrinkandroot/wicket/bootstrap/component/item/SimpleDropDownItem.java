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
package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropDownMenu;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public abstract class SimpleDropDownItem extends DropDownItem
{
    public SimpleDropDownItem(String id, IModel<String> labelModel)
    {
        super(id, labelModel);
    }

    public SimpleDropDownItem(String id, String label)
    {
        super(id, Model.of(label));
    }

    @Override
    protected DropDownMenu createDropDownMenu(String id)
    {
        return new DropDownMenu(id)
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                SimpleDropDownItem.this.populateItems(itemView);
            }
        };
    }

    protected abstract void populateItems(RepeatingView itemView);
}
