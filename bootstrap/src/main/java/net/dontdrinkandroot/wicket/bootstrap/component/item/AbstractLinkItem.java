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

import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.css.CssClass;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class AbstractLinkItem extends AbstractItem<String>
{
    private IModel<CssClass> prependIconModel;

    private IModel<CssClass> appendIconModel;

    public AbstractLinkItem(String id, IModel<String> labelModel)
    {
        super(id, labelModel);
    }

    public AbstractLinkItem(String id, String label)
    {
        super(id, Model.of(label));
    }

    public AbstractLinkItem setPrependIcon(CssClass prependIcon)
    {
        if (prependIcon == null) {
            this.prependIconModel = null;
        } else {
            this.prependIconModel = Model.of(prependIcon);
        }

        return this;
    }

    public AbstractLinkItem setAppendIcon(CssClass appendIcon)
    {
        if (appendIcon == null) {
            this.appendIconModel = null;
        } else {
            this.appendIconModel = Model.of(appendIcon);
        }

        return this;
    }

    public IModel<CssClass> getPrependIconModel()
    {
        return this.prependIconModel;
    }

    public IModel<CssClass> setAppendIconModel()
    {
        return this.appendIconModel;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new DisabledCssBehavior());
        Component link = this.createLink("link");
        link.add(new IconBehavior()
        {

            @Override
            public IModel<CssClass> getPrependIconModel()
            {
                return AbstractLinkItem.this.getPrependIconModel();
            }

            @Override
            public IModel<CssClass> getAppendIconModel()
            {
                return AbstractLinkItem.this.setAppendIconModel();
            }
        });
        this.add(link);
    }

    protected abstract Component createLink(String id);
}
