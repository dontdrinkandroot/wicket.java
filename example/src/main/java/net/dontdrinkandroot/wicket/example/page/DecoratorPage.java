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
package net.dontdrinkandroot.wicket.example.page;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropDownItem;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.page.StandardBootstrapPage;
import net.dontdrinkandroot.wicket.example.ExampleApplication;
import net.dontdrinkandroot.wicket.example.ExampleWebSession;
import net.dontdrinkandroot.wicket.example.component.ThemeDropDownItem;
import net.dontdrinkandroot.wicket.example.page.component.*;
import net.dontdrinkandroot.wicket.example.page.form.FormGroupPage;
import net.dontdrinkandroot.wicket.example.page.form.FormPage;
import net.dontdrinkandroot.wicket.example.page.form.InputGroupPage;
import net.dontdrinkandroot.wicket.example.page.form.ValidationPage;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.head.CssContentHeaderItem;
import org.apache.wicket.markup.head.CssUrlReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
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
    protected void onInitialize()
    {
        super.onInitialize();
        DebugBar debugBar = new DebugBar("debugBar")
        {

            @Override
            protected void onConfigure()
            {
                super.onConfigure();
                this.setVisible(
                        RuntimeConfigurationType.DEVELOPMENT.equals(ExampleApplication.get().getConfigurationType()));
            }
        };
        debugBar.add(new AttributeModifier("style", "z-index: 1030; bottom: -43px; top: initial;"));
        this.add(debugBar);
    }

    @Override
    protected Component createNavBar(String id)
    {
        Component navBar = super.createNavBar(id);
        navBar.add(new CssClassAppender(BootstrapCssClass.NAVBAR_FIXED_TOP));
        return navBar;
    }

    @Override
    protected Component createBrand(String id)
    {
        BookmarkablePageLink<Void> brandLink = new BookmarkablePageLink(id, HomePage.class);
        brandLink.setBody(Model.of("wicket.example"));

        return brandLink;
    }

    @Override
    protected void populateNavbarLeftItems(RepeatingView navbarLeftItemView)
    {
        super.populateNavbarLeftItems(navbarLeftItemView);
        navbarLeftItemView.add(
                new BookmarkablePageLinkItem(navbarLeftItemView.newChildId(), Model.of("CSS"), CssPage.class));
        navbarLeftItemView.add(
                new BookmarkablePageLinkItem(navbarLeftItemView.newChildId(), Model.of("The Grid"), GridPage.class));
        navbarLeftItemView.add(new DropDownItem(navbarLeftItemView.newChildId(), Model.of("Components"))
        {

            @Override
            protected void populateItems(RepeatingView itemView)
            {
                itemView.add(
                        new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Buttons"), ButtonPage.class));
                itemView.add(
                        new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Nav Bars"), NavBarPage.class));
                itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Labels"), LabelPage.class));
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
                        new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Dropdowns"), DropDownPage.class));
                itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Modals"), ModalPage.class));
            }

            @Override
            protected boolean isActive()
            {
                return this.getPage() instanceof ComponentPage;
            }
        });

        navbarLeftItemView.add(new DropDownItem(navbarLeftItemView.newChildId(), Model.of("Forms"))
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
            }

            @Override
            protected boolean isActive()
            {
                return this.getPage() instanceof FormPage;
            }
        });
    }

    @Override
    protected void populateNavbarRightItems(RepeatingView itemView)
    {
        super.populateNavbarRightItems(itemView);
        itemView.add(new ThemeDropDownItem(itemView.newChildId()));
    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
        response.render(this.getBootstrapJavaScriptHeaderItem());
        response.render(new CssUrlReferenceHeaderItem(ExampleWebSession.get().getCurrentTheme().getUrl(), null, null));
        response.render(
                new CssUrlReferenceHeaderItem(
                        "https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css",
                        null,
                        null
                ));
        response.render(new CssContentHeaderItem("body{padding-top: 50px;}", "bodyPadding", null));
        response.render(
                new CssContentHeaderItem(".has-error .help-block .info{color: #737373;}", "infoHelpText", null));
    }
}
