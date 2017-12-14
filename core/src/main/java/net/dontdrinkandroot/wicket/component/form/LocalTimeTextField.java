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
package net.dontdrinkandroot.wicket.component.form;

import net.dontdrinkandroot.wicket.converter.LocalTimeConverter;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalTimeTextField extends AbstractTemporalAccessorTextField<LocalTime>
{
    public LocalTimeTextField(String id)
    {
        super(id, LocalTime.class);
    }

    public LocalTimeTextField(String id, IModel<LocalTime> model)
    {
        super(id, model, LocalTime.class);
    }

    @Override
    protected IConverter<?> createConverter(Class<?> type)
    {
        if (LocalDate.class.isAssignableFrom(type)) {
            return new LocalTimeConverter();
        }

        return null;
    }

    @Override
    protected String[] getInputTypes()
    {
        return new String[]{"text", "time"};
    }
}
