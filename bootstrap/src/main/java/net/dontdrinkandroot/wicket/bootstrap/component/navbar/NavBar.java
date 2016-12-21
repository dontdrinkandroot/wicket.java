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
package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.NavBarStyle;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class NavBar extends GenericPanel<Void>
{
    private IModel<NavBarStyle> styleModel = Model.of(NavBarStyle.DEFAULT);

    public NavBar(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.NAVBAR));
        this.add(new CssClassAppender(this.styleModel));

        this.add(this.createBrand("brand"));

        RepeatingView navBarLeftItemView = new RepeatingView("leftItem");
        this.populateNavbarLeftItems(navBarLeftItemView);
        this.add(navBarLeftItemView);

        this.add(this.createForm("form"));

        RepeatingView navbarRightItemView = new RepeatingView("rightItem");
        this.populateNavbarRightItems(navbarRightItemView);
        this.add(navbarRightItemView);
    }

    protected Component createBrand(String id)
    {
        WebMarkupContainer brandLink = new WebMarkupContainer(id);
        brandLink.setVisible(false);

        return brandLink;
    }

    protected Component createForm(String id)
    {
        WebMarkupContainer navbarForm = new WebMarkupContainer(id);
        navbarForm.setVisible(false);

        return navbarForm;
    }

    public NavBar setStyle(NavBarStyle style)
    {
        this.styleModel.setObject(style);
        return this;
    }

    protected void populateNavbarLeftItems(RepeatingView itemView)
    {
        /* Overwrite to add navbar items on the left side */
    }

    protected void populateNavbarRightItems(RepeatingView itemView)
    {
        /* Overwrite to add navbar items on the right side */
    }
}
