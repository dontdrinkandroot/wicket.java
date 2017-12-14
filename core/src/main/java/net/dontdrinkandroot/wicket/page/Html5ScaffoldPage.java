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
package net.dontdrinkandroot.wicket.page;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @param <T> Type of the model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class Html5ScaffoldPage<T> extends GenericWebPage<T>
{
    public Html5ScaffoldPage()
    {
    }

    public Html5ScaffoldPage(IModel<T> model)
    {
        super(model);
    }

    public Html5ScaffoldPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(this.createPageTitle("pageTitle"));
    }

    /**
     * Creates the {@link Component} that displays the page title. Invisible by default.
     *
     * @param id The id to use when generating the component.
     * @return The page title component.
     */
    protected Component createPageTitle(String id)
    {
        WebMarkupContainer pageTitleContainer = new WebMarkupContainer(id);
        pageTitleContainer.setVisible(false);

        return pageTitleContainer;
    }
}
