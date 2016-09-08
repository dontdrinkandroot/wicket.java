/*
 * Copyright (C) 2012-2016 Philip Washington Sorst <philip@sorst.net>
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
import net.dontdrinkandroot.wicket.bootstrap.component.item.*;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.InnerNavBar;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.NavBarStyle;
import net.dontdrinkandroot.wicket.example.component.NavBarForm;
import net.dontdrinkandroot.wicket.example.page.HomePage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class NavBarPage extends ComponentPage
{

    public NavBarPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Nav Bars");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        InnerNavBar navBarDefault = new InnerNavBar("navBarDefault")
        {

            @Override
            protected Component createBrand(String id)
            {
                BookmarkablePageLink<Void> brandLink = new BookmarkablePageLink<Void>(id, HomePage.class);
                brandLink.setBody(Model.of("Brand"));
                return brandLink;
            }

            @Override
            protected Component createForm(String id)
            {
                return NavBarPage.this.createExampleNavBarForm(id);
            }

            @Override
            protected void populateNavbarLeftItems(RepeatingView itemView)
            {
                NavBarPage.this.populateExampleNavbarLeftItems(itemView);
            }

            @Override
            protected void populateNavbarRightItems(RepeatingView itemView)
            {
                NavBarPage.this.populateExampleNavbarRightItems(itemView);
            }
        };
        this.add(navBarDefault);

        InnerNavBar navBarInverse = new InnerNavBar("navBarInverse")
        {

            @Override
            protected Component createBrand(String id)
            {
                BookmarkablePageLink<Void> brandLink = new BookmarkablePageLink<Void>(id, HomePage.class);
                brandLink.setBody(Model.of("Brand"));
                return brandLink;
            }

            @Override
            protected Component createForm(String id)
            {
                return NavBarPage.this.createExampleNavBarForm(id);
            }

            @Override
            protected void populateNavbarLeftItems(RepeatingView itemView)
            {
                NavBarPage.this.populateExampleNavbarLeftItems(itemView);
            }

            @Override
            protected void populateNavbarRightItems(RepeatingView itemView)
            {
                NavBarPage.this.populateExampleNavbarRightItems(itemView);
            }
        };
        navBarInverse.setStyle(NavBarStyle.INVERSE);
        this.add(navBarInverse);
    }

    protected Component createExampleNavBarForm(String id)
    {
        NavBarForm navBarForm = new NavBarForm(id);
        navBarForm.add(new CssClassAppender(BootstrapCssClass.NAVBAR_LEFT));

        return navBarForm;
    }

    protected void populateExampleNavbarLeftItems(RepeatingView itemView)
    {
        itemView.add(new DropDownItem(itemView.newChildId(), Model.of("DropDown"))
        {

            @Override
            protected void populateItems(RepeatingView itemView)
            {
                itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Action"), HomePage.class));
                itemView.add(new DividerItem(itemView.newChildId()));
                itemView.add(new HeaderItem(itemView.newChildId(), Model.of("A Header")));
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Another Action"),
                                HomePage.class
                        ));
            }
        });
        itemView.add(new NavBarButtonItem<Void>(itemView.newChildId())
        {

            @Override
            protected AbstractLink createLink(String id)
            {
                return new BookmarkablePageLink<Void>(id, HomePage.class).setBody(Model.of("Button"));
            }
        });
    }

    protected void populateExampleNavbarRightItems(RepeatingView itemView)
    {
        itemView.add(new NavBarTextItem(itemView.newChildId(), Model.of("Text")));
    }
}
