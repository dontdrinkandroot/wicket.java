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

import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.LinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem;
import net.dontdrinkandroot.wicket.bootstrap.component.nav.RepeatingNavPills;
import net.dontdrinkandroot.wicket.bootstrap.component.nav.RepeatingNavTabs;
import net.dontdrinkandroot.wicket.example.ExampleWebApplication;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class NavPage extends ComponentPage
{
    public NavPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Navs");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RepeatingNavTabs tabsDefault = new RepeatingNavTabs<Void>("tabsDefault")
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                NavPage.this.populateItems(itemView);
            }
        };
        this.add(tabsDefault);

        RepeatingNavTabs tabsJustified = new RepeatingNavTabs<Void>("tabsJustified")
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                NavPage.this.populateItems(itemView);
            }
        };
        tabsJustified.setJustified(true);
        this.add(tabsJustified);

        RepeatingNavPills pillsDefault = new RepeatingNavPills<Void>("pillsDefault")
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                NavPage.this.populateItems(itemView);
            }
        };
        this.add(pillsDefault);

        RepeatingNavPills pillsStacked = new RepeatingNavPills<Void>("pillsStacked")
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                NavPage.this.populateItems(itemView);
            }
        };
        pillsStacked.setStacked(true);
        this.add(pillsStacked);

        RepeatingNavPills pillsJustified = new RepeatingNavPills<Void>("pillsJustified")
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                NavPage.this.populateItems(itemView);
            }
        };
        pillsJustified.setJustified(true);
        this.add(pillsJustified);
    }

    protected void populateItems(RepeatingView itemView)
    {
        itemView.add(new LinkItem<Void>(itemView.newChildId(), Model.of("Active"))
        {
            @Override
            protected void onClick()
            {
                /* Noop */
            }

            @Override
            protected boolean isActive()
            {
                return true;
            }
        });
        itemView.add(new RepeatingDropdownItem<Void>(itemView.newChildId(), Model.of("Dropdown"))
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                itemView.add(new BookmarkablePageLinkItem(
                        itemView.newChildId(),
                        Model.of("A Link"),
                        ExampleWebApplication.get().getHomePage()
                ));
            }
        });

        LinkItem<Void> disabledItem = new LinkItem<Void>(itemView.newChildId(), Model.of("Disabled"))
        {
            @Override
            protected void onClick()
            {
                /* Noop */
            }
        };
        disabledItem.add(new DisabledCssBehavior());
        disabledItem.setEnabled(false);
        itemView.add(disabledItem);
    }
}
