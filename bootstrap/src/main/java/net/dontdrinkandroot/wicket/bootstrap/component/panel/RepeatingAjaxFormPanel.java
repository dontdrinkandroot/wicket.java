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
package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import net.dontdrinkandroot.wicket.bootstrap.behavior.PanelBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.form.RepeatingAjaxForm;
import net.dontdrinkandroot.wicket.component.basic.Heading;
import net.dontdrinkandroot.wicket.component.basic.Heading.Level;
import org.apache.wicket.Component;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

public class RepeatingAjaxFormPanel<T> extends RepeatingAjaxForm<T>
{
    private PanelBehavior panelBehavior = new PanelBehavior();

    private Level headingLevel = Level.H2;

    private IModel<String> titleModel;

    public RepeatingAjaxFormPanel(String id, IModel<String> titleModel)
    {
        super(id);
        this.titleModel = titleModel;
    }

    public RepeatingAjaxFormPanel(String id, IModel<String> titleModel, IModel<T> model)
    {
        super(id, model);
        this.titleModel = titleModel;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(this.panelBehavior);

        Heading title = new Heading("title", this.titleModel, this.headingLevel);
        this.add(title);
    }

    public RepeatingAjaxFormPanel<T> setHeadingLevel(Level headingLevel)
    {
        this.headingLevel = headingLevel;
        return this;
    }

    @Override
    protected Component createActionsView(String id)
    {
        RepeatingView actionsView = new RepeatingView(id);
        this.populateActions(actionsView);

        return actionsView;
    }
}
