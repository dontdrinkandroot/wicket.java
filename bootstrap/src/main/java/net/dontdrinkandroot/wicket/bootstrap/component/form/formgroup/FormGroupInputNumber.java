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
package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupNumber;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;

/**
 * @param <N> Type of the Number.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupInputNumber<N extends Number & Comparable<N>>
        extends FormGroupInputGroup<N, N, NumberTextField<N>, InputGroupNumber<N>>
{
    public FormGroupInputNumber(String id, IModel<String> labelModel, IModel<N> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected InputGroupNumber<N> createInputGroup(String id)
    {
        return new InputGroupNumber<N>(id, this.getModel())
        {
            @Override
            protected Component createInputGroupAddonBefore(String id)
            {
                return FormGroupInputNumber.this.createInputGroupAddonBefore(id);
            }

            @Override
            protected Component createInputGroupAddonAfter(String id)
            {
                return FormGroupInputNumber.this.createInputGroupAddonAfter(id);
            }
        };
    }
}
