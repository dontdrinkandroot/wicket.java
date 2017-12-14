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

import net.dontdrinkandroot.wicket.converter.LocalDateTimeConverter;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;

import java.time.LocalDateTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalDateTimeTextField extends AbstractTemporalAccessorTextField<LocalDateTime>
{
    public LocalDateTimeTextField(String id)
    {
        super(id, LocalDateTime.class);
    }

    public LocalDateTimeTextField(String id, IModel<LocalDateTime> model)
    {
        super(id, model, LocalDateTime.class);
    }

    @Override
    protected IConverter<?> createConverter(Class<?> type)
    {
        if (LocalDateTime.class.isAssignableFrom(type)) {
            return new LocalDateTimeConverter();
        }

        return null;
    }

    @Override
    protected String[] getInputTypes()
    {
        return new String[]{"text", "datetime-local"};
    }
}
