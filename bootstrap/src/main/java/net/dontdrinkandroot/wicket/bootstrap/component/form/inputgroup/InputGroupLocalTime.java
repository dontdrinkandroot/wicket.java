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

import net.dontdrinkandroot.wicket.component.form.LocalTimeTextField;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.model.IModel;

import java.time.LocalTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InputGroupLocalTime extends InputGroup<LocalTime, LocalTime, LocalTimeTextField>
{
    public InputGroupLocalTime(String id, IModel<LocalTime> model)
    {
        super(id, model);
    }

    @Override
    protected LocalTimeTextField createFormComponent(String id)
    {
        LocalTimeTextField formComponent = new LocalTimeTextField(id, this.getModel())
        {
            @Override
            protected void onComponentTag(ComponentTag tag)
            {
                tag.put("type", "time");
                super.onComponentTag(tag);
            }
        };
        formComponent.add(new HTML5Attributes());

        return formComponent;
    }
}
