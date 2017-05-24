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
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.InnerNavbar;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarStyle;
import net.dontdrinkandroot.wicket.example.component.NavbarForm;
import net.dontdrinkandroot.wicket.example.page.HomePage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class NavbarPage extends ComponentPage
{
    public NavbarPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Navbars");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        InnerNavbar navBarDefault = new InnerNavbar("navBarDefault")
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
                return NavbarPage.this.createExampleNavbarForm(id);
            }

            @Override
            protected void populateNavbarLeftItems(RepeatingView itemView)
            {
                NavbarPage.this.populateExampleNavbarLeftItems(itemView);
            }

            @Override
            protected void populateNavbarRightItems(RepeatingView itemView)
            {
                NavbarPage.this.populateExampleNavbarRightItems(itemView);
            }
        };
        this.add(navBarDefault);

        InnerNavbar navBarInverse = new InnerNavbar("navBarInverse")
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
                return NavbarPage.this.createExampleNavbarForm(id);
            }

            @Override
            protected void populateNavbarLeftItems(RepeatingView itemView)
            {
                NavbarPage.this.populateExampleNavbarLeftItems(itemView);
            }

            @Override
            protected void populateNavbarRightItems(RepeatingView itemView)
            {
                NavbarPage.this.populateExampleNavbarRightItems(itemView);
            }
        };
        navBarInverse.setStyle(NavbarStyle.INVERSE);
        this.add(navBarInverse);
    }

    protected Component createExampleNavbarForm(String id)
    {
        NavbarForm navBarForm = new NavbarForm(id);
        navBarForm.add(new CssClassAppender(BootstrapCssClass.NAVBAR_LEFT));

        return navBarForm;
    }

    protected void populateExampleNavbarLeftItems(RepeatingView itemView)
    {
        itemView.add(new RepeatingDropdownItem(itemView.newChildId(), Model.of("Dropdown"))
        {

            @Override
            protected void populateItems(RepeatingView itemView)
            {
                itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Action"), HomePage.class));
                itemView.add(new SeparatorItem(itemView.newChildId()));
                itemView.add(new DropdownHeaderItem(itemView.newChildId(), Model.of("A Header")));
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Another Action"),
                                HomePage.class
                        ));
            }
        });
        itemView.add(new NavbarButtonItem<Void>(itemView.newChildId())
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
        itemView.add(new NavbarTextItem(itemView.newChildId(), Model.of("Text")));
    }
}
