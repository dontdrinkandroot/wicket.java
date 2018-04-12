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
package net.dontdrinkandroot.wicket.example.page;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.Navbar;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.RepeatingNavbarNav;
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarPosition;
import net.dontdrinkandroot.wicket.bootstrap.css.Spacing;
import net.dontdrinkandroot.wicket.bootstrap.headeritem.FontAwesomeCssHeaderItem;
import net.dontdrinkandroot.wicket.example.ExampleWebSession;
import net.dontdrinkandroot.wicket.example.component.BuildInfoItem;
import net.dontdrinkandroot.wicket.example.component.ThemeDropdownItem;
import net.dontdrinkandroot.wicket.example.headeritem.HighlightJsInitHeaderItem;
import net.dontdrinkandroot.wicket.example.page.component.*;
import net.dontdrinkandroot.wicket.example.page.form.*;
import net.dontdrinkandroot.wicket.extras.page.StandardBootstrapPage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssContentHeaderItem;
import org.apache.wicket.markup.head.CssUrlReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public abstract class DecoratorPage<T> extends StandardBootstrapPage<T>
{
    public DecoratorPage()
    {
        super();
    }

    public DecoratorPage(PageParameters parameters)
    {
        super(parameters);
    }

    public DecoratorPage(IModel<T> model)
    {
        super(model);
    }

    @Override
    protected IModel<String> createPageTitlePrefixModel()
    {
        return Model.of("wicket.example");
    }

    @Override
    protected Component createNavbar(String id)
    {
        Navbar navbar = new Navbar(id)
        {
            @Override
            protected Component createBrand(String id)
            {
                BookmarkablePageLink<Void> brandLink = new BookmarkablePageLink<>(id, HomePage.class);
                brandLink.setBody(Model.of("wicket.example"));

                return brandLink;
            }

            @Override
            protected void populateCollapseItems(RepeatingView collapseItemView)
            {
                super.populateCollapseItems(collapseItemView);

                RepeatingNavbarNav leftItems = new RepeatingNavbarNav<Void>(collapseItemView.newChildId())
                {
                    @Override
                    protected void populateItems(RepeatingView itemView)
                    {
                        super.populateItems(itemView);
                        DecoratorPage.this.populateNavbarLeftItems(itemView);
                    }
                };
                leftItems.add(new CssClassAppender(new Spacing(
                        Spacing.Property.MARGIN,
                        Spacing.Side.RIGHT,
                        Spacing.Size.AUTO
                )));
                collapseItemView.add(leftItems);

                RepeatingNavbarNav rightItems = new RepeatingNavbarNav<Void>(collapseItemView.newChildId())
                {
                    @Override
                    protected void populateItems(RepeatingView itemView)
                    {
                        super.populateItems(itemView);

                        itemView.add(new ThemeDropdownItem(itemView.newChildId()));
                        itemView.add(new BuildInfoItem(itemView.newChildId()));
                    }
                };
                collapseItemView.add(rightItems);
            }
        };
        navbar.setPosition(NavbarPosition.FIXED_TOP);
        navbar.add(new CssClassAppender(BackgroundColor.LIGHT));
        return navbar;
    }

    protected void populateNavbarLeftItems(RepeatingView leftItemView)
    {
        leftItemView.add(
                new BookmarkablePageLinkItem(
                        leftItemView.newChildId(),
                        Model.of("Getting Started"),
                        GettingStartedPage.class
                ));
        leftItemView.add(
                new BookmarkablePageLinkItem(leftItemView.newChildId(), Model.of("CSS"), CssPage.class));
        leftItemView.add(
                new BookmarkablePageLinkItem(leftItemView.newChildId(), Model.of("The Grid"), GridPage.class));
        leftItemView.add(new RepeatingDropdownItem<Void>(leftItemView.newChildId(), Model.of("Components"))
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                itemView.add(
                        new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Buttons"), ButtonPage.class));
                itemView.add(
                        new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Panels"), PanelPage.class));
                itemView.add(
                        new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Navs"), NavPage.class));
                itemView.add(
                        new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Navbars"), NavbarPage.class));
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Breadcrumbs"),
                                BreadcrumbPage.class
                        ));
                itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Badges"), BadgePage.class));
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Alerts and Feedback"),
                                AlertPage.class
                        ));
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Progress Bars"),
                                ProgressBarPage.class
                        ));
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Pagination"),
                                PaginationPage.class
                        ));
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Dropdowns"),
                                DropdownPage.class
                        ));
                itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Modals"), ModalPage.class));
            }

            @Override
            protected boolean isActive()
            {
                return this.getPage() instanceof ComponentPage;
            }
        });

        leftItemView.add(new RepeatingDropdownItem<Void>(leftItemView.newChildId(), Model.of("Forms"))
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Form Groups and Form Styles"),
                                FormGroupPage.class
                        ));
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Input Groups"),
                                InputGroupPage.class
                        ));
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Validations"),
                                ValidationPage.class
                        ));
                itemView.add(
                        new BookmarkablePageLinkItem(
                                itemView.newChildId(),
                                Model.of("Ajax Forms"),
                                AjaxFormPage.class
                        ));
            }

            @Override
            protected boolean isActive()
            {
                return this.getPage() instanceof FormPage;
            }
        });
    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
        response.render(this.getBootstrapJavaScriptHeaderItem());
        response.render(new CssUrlReferenceHeaderItem(ExampleWebSession.get().getCurrentTheme().getUrl(), null, null));
        response.render(new FontAwesomeCssHeaderItem());
        response.render(new CssContentHeaderItem("body{padding-top: 56px;}", "bodyPadding", null));
        response.render(new CssContentHeaderItem(
                ".has-error .help-block .info{color: #737373;}",
                "infoHelpText",
                null
        ));
        response.render(new OnDomReadyHeaderItem(" $(\"a[rel='external']\").attr('target', '_blank');"));
        response.render(new HighlightJsInitHeaderItem());
    }
}
