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
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;

/**
 * @param <N> Type of the Number.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InputGroupNumber<N extends Number & Comparable<N>> extends InputGroup<N, N, NumberTextField<N>>
{
    public InputGroupNumber(String id, IModel<N> model)
    {
        super(id, model);
    }

    @Override
    protected NumberTextField<N> createFormComponent(String id)
    {
        NumberTextField<N> formComponent = new NumberTextField<N>(id, this.getModel())
        {
            @Override
            protected void onComponentTag(ComponentTag tag)
            {
                tag.put("type", "number");
                super.onComponentTag(tag);
            }
        };
        formComponent.add(new HTML5Attributes());

        return formComponent;
    }
}
