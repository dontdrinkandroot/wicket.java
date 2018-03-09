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
import net.dontdrinkandroot.wicket.css.CssClass;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ProgressBar extends GenericPanel<Integer>
{
    private WebMarkupContainer bar;

    private boolean animated = false;

    private boolean striped = false;

    public ProgressBar(String id)
    {
        this(id, new Model<>(0));
    }

    public ProgressBar(String id, IModel<Integer> model)
    {
        super(id, model);
    }

    public ProgressBar(String id, IModel<Integer> model, boolean striped)
    {
        super(id, model);

        this.striped = striped;
    }

    public ProgressBar(String id, IModel<Integer> model, boolean striped, boolean animated)
    {
        super(id, model);

        this.animated = animated;
        this.striped = striped;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.PROGRESS));

        this.bar = new WebMarkupContainer("bar");

        this.bar.add(new AttributeModifier("aria-valuenow", this.getModel()));

        this.bar.add(new AttributeModifier(
                "style",
                (IModel<String>) () -> String.format("width: %d%%;", ProgressBar.this.getModelObject())
        ));

        /* Animated */
        this.bar.add(new CssClassAppender((IModel<CssClass>) () -> {
            if (ProgressBar.this.isAnimated()) {
                return BootstrapCssClass.PROGRESS_BAR_ANIMATED;
            }

            return null;
        }));

        /* Striped */
        this.bar.add(new CssClassAppender((IModel<CssClass>) () -> {
            if (ProgressBar.this.isStriped()) {
                return BootstrapCssClass.PROGRESS_BAR_STRIPED;
            }

            return null;
        }));

        this.bar.setOutputMarkupId(true);
        this.add(this.bar);
    }

    public ProgressBar setAnimated(boolean animated)
    {
        this.animated = animated;
        return this;
    }

    public boolean isAnimated()
    {
        return this.animated;
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
