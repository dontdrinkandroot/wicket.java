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
package net.dontdrinkandroot.wicket.example.page.component;

import net.dontdrinkandroot.wicket.bootstrap.behavior.AlertBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class AlertPage extends ComponentPage
{

    public AlertPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RepeatingView alertView = new RepeatingView("alert");
        this.add(alertView);
        for (AlertStyle style : AlertStyle.values()) {
            Label label = new Label(alertView.newChildId(), Model.of(style.name().toLowerCase()));
            label.add(new AlertBehavior(Model.of(style)));
            alertView.add(label);
        }
    }

    @Override
    protected void onBeforeRender()
    {
        super.onBeforeRender();

        this.info("Info Message");
        this.debug("Debug message");
        this.success("Success Message");
        this.warn("Warn Message");
        this.error("Error Message");
        this.fatal("Fatal Message");
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Alerts and Feedback");
    }
}
