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
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownDividerItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropdownHeaderItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.Navbar;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.NavbarButton;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.NavbarText;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.RepeatingNavbarNav;
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarStyle;
import net.dontdrinkandroot.wicket.example.component.NavbarForm;
import net.dontdrinkandroot.wicket.example.page.HomePage;
import org.apache.wicket.Component;
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

        Navbar navbarLight = this.createExampleNavbar("navbarLight");
        navbarLight.add(new CssClassAppender(BackgroundColor.LIGHT));
        this.add(navbarLight);

        Navbar navbarDark = this.createExampleNavbar("navbarDark");
        navbarDark.setStyle(NavbarStyle.DARK);
        navbarDark.add(new CssClassAppender(BackgroundColor.DARK));
        this.add(navbarDark);
    }

    protected Navbar createExampleNavbar(String id)
    {
        Navbar navbar = new Navbar(id)
        {
            @Override
            protected Component createBrand(String id)
            {
                BookmarkablePageLink brandLink = new BookmarkablePageLink(id, HomePage.class);
                brandLink.setBody(Model.of("Brand"));
                return brandLink;
            }

            @Override
            protected void populateCollapseItems(RepeatingView collapseItemView)
            {
                super.populateCollapseItems(collapseItemView);

                collapseItemView.add(new RepeatingNavbarNav<Void>(collapseItemView.newChildId())
                {
                    @Override
                    protected void populateItems(RepeatingView itemView)
                    {
                        super.populateItems(itemView);
                        itemView.add(new RepeatingDropdownItem<Void>(itemView.newChildId(), Model.of("Dropdown"))
                        {
                            @Override
                            protected void populateItems(RepeatingView itemView)
                            {
                                itemView.add(new BookmarkablePageLinkItem(
                                        itemView.newChildId(),
                                        Model.of("Action"),
                                        HomePage.class
                                ));
                                itemView.add(new DropdownDividerItem(itemView.newChildId()));
                                itemView.add(new DropdownHeaderItem(itemView.newChildId(), Model.of("A Header")));
                                itemView.add(
                                        new BookmarkablePageLinkItem(
                                                itemView.newChildId(),
                                                Model.of("Another Action"),
                                                HomePage.class
                                        ));
                            }
                        });
                        itemView.add(new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Link"),
                                NavbarPage.class
                        ));
                    }
                });

                NavbarForm form = new NavbarForm(collapseItemView.newChildId());
                collapseItemView.add(form);

                NavbarText text = new NavbarText(collapseItemView.newChildId(), Model.of("Text"));
                collapseItemView.add(text);

                NavbarButton button = new NavbarButton<Void>(collapseItemView.newChildId())
                {
                    @Override
                    public void onClick()
                    {
                        /* Noop */
                    }
                };
                button.setAlignment(NavbarAlignment.RIGHT);
                button.setBody(Model.of("Button"));
                collapseItemView.add(button);
            }
        };
        return navbar;
    }
}
