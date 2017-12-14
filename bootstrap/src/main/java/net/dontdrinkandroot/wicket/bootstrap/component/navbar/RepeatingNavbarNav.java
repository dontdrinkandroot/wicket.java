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
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RepeatingNavbarNav extends Panel
{
    private IModel<NavbarAlignment> alignmentModel = Model.of(NavbarAlignment.LEFT);

    public RepeatingNavbarNav(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.NAV));
        this.add(new CssClassAppender(BootstrapCssClass.NAVBAR_NAV));
        this.add(new CssClassAppender(this.alignmentModel));

        RepeatingView itemView = new RepeatingView("item");
        this.populateItems(itemView);
        this.add(itemView);
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        tag.setName("ul");
        super.onComponentTag(tag);
    }

    protected void populateItems(RepeatingView itemView)
    {
        /* Hook */
    }

    public RepeatingNavbarNav setAlignment(NavbarAlignment alignment)
    {
        this.alignmentModel.setObject(alignment);
        return this;
    }
}
