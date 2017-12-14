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
package net.dontdrinkandroot.wicket.bootstrap.component.progress;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ProgressBarStyle;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ProgressBar extends GenericPanel<Integer>
{
    private WebMarkupContainer bar;

    private boolean active = false;

    private boolean striped = false;

    private IModel<ProgressBarStyle> styleModel;

    public ProgressBar(String id)
    {
        this(id, new Model<>(0));
    }

    public ProgressBar(String id, IModel<Integer> model)
    {
        super(id, model);
    }

    public ProgressBar(String id, IModel<Integer> model, ProgressBarStyle style)
    {
        super(id, model);

        this.styleModel = Model.of(style);
    }

    public ProgressBar(String id, IModel<Integer> model, ProgressBarStyle style, boolean striped)
    {
        super(id, model);

        this.styleModel = Model.of(style);
        this.striped = striped;
    }

    public ProgressBar(String id, IModel<Integer> model, ProgressBarStyle style, boolean striped, boolean active)
    {
        super(id, model);

        this.styleModel = Model.of(style);
        this.active = active;
        this.striped = striped;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.PROGRESS));

        /* Active */
        this.add(new CssClassAppender(new AbstractReadOnlyModel<BootstrapCssClass>()
        {
            @Override
            public BootstrapCssClass getObject()
            {
                if (ProgressBar.this.isActive()) {
                    return BootstrapCssClass.ACTIVE;
                }

                return null;
            }
        }));

        /* Striped */
        this.add(new CssClassAppender(new AbstractReadOnlyModel<BootstrapCssClass>()
        {
            @Override
            public BootstrapCssClass getObject()
            {
                if (ProgressBar.this.isStriped()) {
                    return BootstrapCssClass.PROGRESS_STRIPED;
                }

                return null;
            }
        }));

        this.bar = new WebMarkupContainer("bar");

        this.bar.add(new AttributeModifier("aria-valuenow", this.getModel()));

        this.bar.add(new AttributeModifier("style", new AbstractReadOnlyModel<String>()
        {
            @Override
            public String getObject()
            {
                return String.format("width: %d%%;", ProgressBar.this.getModelObject());
            }
        }));

        /* Style */
        this.bar.add(new CssClassAppender(this.styleModel));

        this.bar.setOutputMarkupId(true);
        this.add(this.bar);
    }

    public void setBarStyle(ProgressBarStyle barStyle)
    {
        this.styleModel.setObject(barStyle);
    }

    public ProgressBarStyle getBarStyle()
    {
        return this.styleModel.getObject();
    }

    public ProgressBar setActive(boolean active)
    {
        this.active = active;
        return this;
    }

    public boolean isActive()
    {
        return this.active;
    }

    public ProgressBar setStriped(boolean striped)
    {
        this.striped = striped;
        return this;
    }

    public boolean isStriped()
    {
        return this.striped;
    }

    public void update(AjaxRequestTarget target)
    {
        target.appendJavaScript(
                String.format("$('#%s').css({width: '%d%%'});", this.bar.getMarkupId(), this.getModelObject()));
        target.appendJavaScript(
                String.format("$('#%s').attr('aria-valuenow', %d);", this.bar.getMarkupId(), this.getModelObject()));
    }

    public WebMarkupContainer getBar()
    {
        return this.bar;
    }
}
