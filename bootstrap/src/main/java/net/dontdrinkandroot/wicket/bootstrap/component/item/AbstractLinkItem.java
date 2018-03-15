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
import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.model.CssClassToggleModel;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @param <T> Type of the model object.
 * @param <L> Type of the {@link AbstractLink}.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class AbstractLinkItem<T, L extends AbstractLink> extends AbstractLabeledItem<T>
{
    private IModel<CssClass> prependIconModel;

    private IModel<CssClass> appendIconModel;

    private L link;

    public AbstractLinkItem(String id, IModel<String> labelModel)
    {
        this(id, labelModel, null);
    }

    public AbstractLinkItem(String id, IModel<String> labelModel, IModel<T> model)
    {
        super(id, labelModel, model);
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

        this.link = this.createLink("link");
        this.link.setBody(this.getLabel());
        this.add(new DisabledCssBehavior());
        this.link.add(new IconBehavior()
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
        this.add(this.link);

        /* Link is also active if item is active */
        this.link.add(new CssClassAppender(new CssClassToggleModel(BootstrapCssClass.ACTIVE)
        {
            @Override
            protected boolean isActive()
            {
                return AbstractLinkItem.this.isActive();
            }
        }));

        this.link.add(new CssClassAppender((IModel<CssClass>) () -> {

            MarkupContainer parent = AbstractLinkItem.this.getParent();

            if (parent instanceof ItemContainer) {
                return ((ItemContainer) parent).getLinkClass();
            }

            parent = parent.getParent();
            if (parent instanceof ItemContainer) {
                return ((ItemContainer) parent).getLinkClass();
            }

            return null;
        }));
    }

    public L getLink()
    {
        return this.link;
    }

    protected abstract L createLink(String id);
}
