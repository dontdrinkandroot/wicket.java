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
package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.*;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class Navbar extends Panel
{
    private IModel<NavbarPosition> positionModel = Model.of();

    private IModel<NavbarStyle> styleModel = Model.of(NavbarStyle.LIGHT);

    private IModel<NavbarExpand> expandModel = Model.of(NavbarExpand.LG);

    private IModel<ContainerStyle> containerStyleModel = Model.of(ContainerStyle.DEFAULT);

    private WebMarkupContainer navbarCollapse;

    public Navbar(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.NAVBAR));
        this.add(new CssClassAppender(this.styleModel));
        this.add(new CssClassAppender(this.positionModel));
        this.add(new CssClassAppender(this.expandModel));

        WebMarkupContainer container = new WebMarkupContainer("container");
        container.add(new CssClassAppender(this.containerStyleModel.getObject()));
        this.add(container);

        container.add(this.createBrand("navbarBrand"));

        this.navbarCollapse = new WebMarkupContainer("navbarCollapse");
        this.navbarCollapse.setOutputMarkupId(true);
        container.add(this.navbarCollapse);

        Component navbarToggle = this.createNavbarToggler("navbarToggler");
        navbarToggle.add(new AttributeModifier(
                "data-target",
                (IModel<String>) () -> String.format("#%s", Navbar.this.getNavbarCollapseId())
        ));
        container.add(navbarToggle);

        RepeatingView collapseItemView = new RepeatingView("navbarCollapseItem");
        this.populateCollapseItems(collapseItemView);
        this.navbarCollapse.add(collapseItemView);
    }

    protected Component createNavbarToggler(String id)
    {
        return new NavbarToggler(id);
    }

    protected Component createBrand(String id)
    {
        WebMarkupContainer brandLink = new WebMarkupContainer(id);
        brandLink.setVisible(false);

        return brandLink;
    }

    protected void populateCollapseItems(RepeatingView collapseItemView)
    {
        /* Hook */
    }

    public Navbar setPosition(NavbarPosition position)
    {
        this.positionModel.setObject(position);
        return this;
    }

    public Navbar setStyle(NavbarStyle style)
    {
        this.styleModel.setObject(style);
        return this;
    }

    public Navbar setContainerStyle(ContainerStyle containerStyle)
    {
        this.containerStyleModel.setObject(containerStyle);
        return this;
    }

    public Navbar setExpand(NavbarExpand expand)
    {
        this.expandModel.setObject(expand);
        return this;
    }

    public String getNavbarCollapseId()
    {
        return this.navbarCollapse.getMarkupId();
    }
}
