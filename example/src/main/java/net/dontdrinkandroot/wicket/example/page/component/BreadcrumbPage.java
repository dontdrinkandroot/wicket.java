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

import net.dontdrinkandroot.wicket.bootstrap.component.breadcrumb.RepeatingBreadcrumb;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.example.ExampleWebApplication;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BreadcrumbPage extends ComponentPage
{
    public BreadcrumbPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Breadcrumbs");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RepeatingBreadcrumb<Void> breadcrumb = new RepeatingBreadcrumb<Void>("breadcrumb")
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Examples"),
                        ExampleWebApplication.get().getHomePage()
                ));

                itemView.add(new BookmarkablePageLinkItem(
                        itemView.newChildId(),
                        Model.of("Breadcrumbs"),
                        BreadcrumbPage.class
                ));
            }
        };
        this.add(breadcrumb);
    }
}
