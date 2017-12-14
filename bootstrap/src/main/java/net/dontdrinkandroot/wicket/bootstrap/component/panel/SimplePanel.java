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

import net.dontdrinkandroot.wicket.component.basic.Heading;
import net.dontdrinkandroot.wicket.component.basic.Heading.Level;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * A {@link Panel} with a standard heading. The body can be rendered via wicket:extend.
 *
 * @param <T> Type of the Model Object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SimplePanel<T> extends Panel<T>
{
    protected IModel<String> headingModel;

    protected Level headingLevel;

    public SimplePanel(String id, IModel<T> model)
    {
        super(id, model);
    }

    public SimplePanel(String id, IModel<String> headingModel, Heading.Level headingLevel)
    {
        super(id);

        this.headingModel = headingModel;
        this.headingLevel = headingLevel;
    }

    public SimplePanel(String id, IModel<T> model, IModel<String> headingModel)
    {
        super(id, model);

        this.headingModel = headingModel;
        this.headingLevel = Heading.Level.H2;
    }

    public SimplePanel(String id, IModel<T> model, IModel<String> headingModel, Heading.Level headingLevel)
    {
        super(id, model);

        this.headingModel = headingModel;
        this.headingLevel = headingLevel;
    }

    @Override
    protected Component createHeading(String id)
    {
        return new PanelHeading(id, this.getHeadingModel(), this.getHeadingLevel());
    }

    public IModel<String> getHeadingModel()
    {
        return this.headingModel;
    }

    public Level getHeadingLevel()
    {
        return this.headingLevel;
    }
}
