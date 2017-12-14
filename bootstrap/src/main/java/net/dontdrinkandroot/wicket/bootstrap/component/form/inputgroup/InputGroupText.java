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
package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InputGroupText extends InputGroup<String, String, TextField<String>>
{
    public InputGroupText(String id, IModel<String> model)
    {
        super(id, model);
    }

    @Override
    protected TextField<String> createFormComponent(String id)
    {
        TextField<String> formComponent = new TextField<String>(id, this.getModel(), String.class)
        {
            @Override
            protected void onComponentTag(ComponentTag tag)
            {
                tag.put("type", "text");
                super.onComponentTag(tag);
            }
        };
        formComponent.add(new HTML5Attributes());

        return formComponent;
    }
}
