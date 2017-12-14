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
package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

/**
 * A {@link Panel} that has no default components. You need to overwrite the corresponding create methods.
 *
 * @param <T> Type of the Model Object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class PlainPanel<T> extends Panel<T>
{
    protected Component body;

    public PlainPanel(String id)
    {
        super(id);
    }

    public PlainPanel(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.body = this.createBody(Panel.BODY_ID);
        this.body.add(new CssClassAppender(BootstrapCssClass.PANEL_BODY));
        this.add(this.body);
    }

    protected Component createBody(String id)
    {
        final WebMarkupContainer bodyContainer = new WebMarkupContainer(id);
        bodyContainer.setVisible(false);

        return bodyContainer;
    }
}
