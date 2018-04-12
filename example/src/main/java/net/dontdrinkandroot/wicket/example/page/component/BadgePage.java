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

import net.dontdrinkandroot.wicket.bootstrap.behavior.BadgeBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BadgePage extends ComponentPage
{

    public BadgePage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Badges");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RepeatingView badgeView = new RepeatingView("badge");
        this.add(badgeView);
        for (BadgeStyle style : BadgeStyle.values()) {
            Label label = new Label(badgeView.newChildId(), Model.of(style.name().toLowerCase()));
            label.add(new BadgeBehavior(Model.of(style)));
            badgeView.add(label);
        }
    }
}
