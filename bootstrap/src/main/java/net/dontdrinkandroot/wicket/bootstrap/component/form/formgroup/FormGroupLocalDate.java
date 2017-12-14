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

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupLocalDate;
import net.dontdrinkandroot.wicket.component.form.LocalDateTextField;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import java.time.LocalDate;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupLocalDate extends FormGroupInputGroup<LocalDate, LocalDate, LocalDateTextField, InputGroupLocalDate>
{
    public FormGroupLocalDate(String id, IModel<String> labelModel, IModel<LocalDate> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected InputGroup<LocalDate, LocalDate, LocalDateTextField> createInputGroup(String id)
    {
        return new InputGroupLocalDate(id, this.getModel())
        {
            @Override
            protected Component createInputGroupAddonBefore(String id)
            {
                return FormGroupLocalDate.this.createInputGroupAddonBefore(id);
            }

            @Override
            protected Component createInputGroupAddonAfter(String id)
            {
                return FormGroupLocalDate.this.createInputGroupAddonAfter(id);
            }
        };
    }
}
