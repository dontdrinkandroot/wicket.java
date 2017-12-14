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
import net.dontdrinkandroot.wicket.behavior.aria.Aria;
import net.dontdrinkandroot.wicket.behavior.aria.AriaAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavbarToggle extends Panel
{
    public NavbarToggle(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.NAVBAR_TOGGLE));
        this.add(new CssClassAppender(BootstrapCssClass.COLLAPSED));
        this.add(new AttributeAppender("data-toggle", "collapse"));
        this.add(new AriaAppender(Aria.EXPANDED, "false"));

        Label label = new Label("label", new ResourceModel("navbar.toggle", "Toggle navigation"));
        label.add(new CssClassAppender(BootstrapCssClass.SR_ONLY));
        this.add(label);
    }
}
