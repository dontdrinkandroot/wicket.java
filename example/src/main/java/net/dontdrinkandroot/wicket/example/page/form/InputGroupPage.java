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
package net.dontdrinkandroot.wicket.example.page.form;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupText;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupLabel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InputGroupPage extends FormPage
{
    public InputGroupPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        InputGroupText labels = new InputGroupText("labels", Model.of(""))
        {
            @Override
            protected Component createInputGroupAddonBefore(String id)
            {
                return new InputGroupLabel(id, Model.of("Before"));
            }

            @Override
            protected Component createInputGroupAddonAfter(String id)
            {
                return new InputGroupLabel(id, Model.of("After"));
            }
        };
        this.add(labels);

        InputGroupText buttons = new InputGroupText("buttons", Model.of(""))
        {
            @Override
            protected Component createInputGroupAddonBefore(String id)
            {
                return new InputGroupButton<Void>(id)
                {
                    @Override
                    protected Component createLink(String id)
                    {
                        return new Label(id, Model.of("Before"));
                    }
                };
            }

            @Override
            protected Component createInputGroupAddonAfter(String id)
            {
                return new InputGroupButton<Void>(id)
                {
                    @Override
                    protected Component createLink(String id)
                    {
                        return new Label(id, Model.of("After"));
                    }
                };
            }
        };
        this.add(buttons);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Input Groups");
    }
}
