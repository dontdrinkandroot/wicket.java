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

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.model.CssClassToggleModel;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

/**
 * Base class for most items. Items can be used in Navs or DropDown menus. Items support an active state which can
 * be changed by overriding the {@link AbstractItem#isActive()} method.
 *
 * @param <T> Type of the item.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AbstractItem<T> extends GenericPanel<T>
{
    public AbstractItem(String id)
    {
        super(id);
    }

    public AbstractItem(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(new CssClassToggleModel(BootstrapCssClass.ACTIVE)
        {
            @Override
            protected boolean isActive()
            {
                return AbstractItem.this.isActive();
            }
        }));

        this.add(new CssClassAppender((IModel<CssClass>) () -> {

            MarkupContainer parent = AbstractItem.this.getParent();

            if (parent instanceof ItemContainer) {
                return ((ItemContainer) parent).getItemClass();
            }

            parent = parent.getParent();
            if (parent instanceof ItemContainer) {
                return ((ItemContainer) parent).getItemClass();
            }

            return null;
        }));
    }

    protected boolean isActive()
    {
        return false;
    }
}
