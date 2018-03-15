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

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownDividerItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownHeaderItem;
import net.dontdrinkandroot.wicket.example.page.HomePage;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class DropdownPage extends ComponentPage
{
    public DropdownPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        DropdownMenu dropdownMenu = new DropdownMenu("dropdownMenu")
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                DropdownPage.this.populateItems(itemView);
            }
        };
        this.add(dropdownMenu);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Dropdowns");
    }

    protected void populateItems(RepeatingView itemView)
    {
        itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Action"), HomePage.class));
        itemView.add(new DropdownDividerItem(itemView.newChildId()));
        itemView.add(new DropdownHeaderItem(itemView.newChildId(), Model.of("A Header")));
        itemView.add(new BookmarkablePageLinkItem(
                itemView.newChildId(),
                Model.of("Another Action"),
                DropdownPage.class
        ));
    }
}
