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

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.progress.ProgressBar;
import net.dontdrinkandroot.wicket.bootstrap.css.ProgressBarStyle;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Iterator;

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

        final IModel<Integer> valueModel = new Model<Integer>(33);
        final RepeatingView progressBarView = new RepeatingView("progressBarStyle");
        this.add(progressBarView);
        for (ProgressBarStyle style : ProgressBarStyle.values()) {
            progressBarView.add(new ProgressBar(progressBarView.newChildId(), valueModel, style));
        }

        AjaxLink<Void> updateButton = new AjaxLink<Void>("updateButton")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                valueModel.setObject((int) Math.round(Math.random() * 100));
                Iterator<Component> childIterator = progressBarView.iterator();
                while (childIterator.hasNext()) {
                    Component child = childIterator.next();
                    ((ProgressBar) child).update(target);
                }
            }
        };
        updateButton.setBody(Model.of("update"));
        updateButton.add(new ButtonBehavior());
        this.add(updateButton);

        ProgressBar stripedBar = new ProgressBar("stripedBar", valueModel, ProgressBarStyle.DEFAULT, true, false);
        this.add(stripedBar);

        ProgressBar activeBar = new ProgressBar("activeBar", valueModel, ProgressBarStyle.DEFAULT, true, true);
        this.add(activeBar);
    }
}
