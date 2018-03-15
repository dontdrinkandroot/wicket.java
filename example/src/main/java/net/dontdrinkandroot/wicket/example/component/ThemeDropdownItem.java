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
package net.dontdrinkandroot.wicket.example.component;

import net.dontdrinkandroot.wicket.bootstrap.component.item.AbstractLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem;
import net.dontdrinkandroot.wicket.example.ExampleWebSession;
import net.dontdrinkandroot.wicket.example.model.Theme;
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class ThemeDropdownItem extends RepeatingDropdownItem<Void>
{
    public ThemeDropdownItem(String id)
    {
        super(
                id,
                new ConcatenatingStringModel(
                        Model.of("Theme"),
                        ": ",
                        (IModel<String>) () -> ExampleWebSession.get().getCurrentTheme().getName()
                )
        );
    }

    @Override
    protected void populateItems(RepeatingView itemView)
    {
        for (Theme theme : Theme.getAvailableThemes()) {
            itemView.add(this.createThemeLinkItem(itemView.newChildId(), theme));
        }
    }

    protected AbstractLinkItem createThemeLinkItem(String id, Theme theme)
    {
        AbstractLinkItem themeLinkItem = new AbstractLinkItem<Void, StatelessLink<Void>>(id, Model.of(theme.getName()))
        {
            @Override
            protected StatelessLink<Void> createLink(String id)
            {
                StatelessLink<Void> themeLink = new StatelessLink<Void>(id)
                {
                    @Override
                    public void onClick()
                    {
                        ExampleWebSession.get().setCurrentTheme(theme);
                        this.setResponsePage(this.getPage());
                    }
                };

                return themeLink;
            }
        };

        return themeLinkItem;
    }
}
