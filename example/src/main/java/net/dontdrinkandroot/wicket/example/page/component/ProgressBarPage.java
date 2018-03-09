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

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.progress.ProgressBar;
import net.dontdrinkandroot.wicket.bootstrap.css.Spacing;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ProgressBarPage extends ComponentPage
{
    public ProgressBarPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Progress Bars");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        final IModel<Integer> valueModel = new Model<>(33);

        ProgressBar defaultBar = new ProgressBar("defaultBar", valueModel);
        defaultBar.add(new CssClassAppender(new Spacing(
                Spacing.Property.MARGIN,
                Spacing.Side.BOTTOM,
                Spacing.Size.HALF
        )));
        this.add(defaultBar);

        AjaxLink<Void> updateButton = new AjaxLink<Void>("updateButton")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                valueModel.setObject((int) Math.round(Math.random() * 100));
                defaultBar.update(target);
            }
        };
        updateButton.setBody(Model.of("update"));
        updateButton.add(new ButtonBehavior());
        this.add(updateButton);

        ProgressBar stripedBar = new ProgressBar("stripedBar", valueModel, true, false);
        this.add(stripedBar);

        ProgressBar animatedBar = new ProgressBar("animatedBar", valueModel, true, true);
        this.add(animatedBar);
    }
}
