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
package net.dontdrinkandroot.wicket.converter;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Locale;

/**
 * Converts between String and a {@link TemporalAccessor}
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AbstractTemporalAccessorConverter<T extends TemporalAccessor> implements IConverter<T>
{
    private DateTimeFormatter formatter;

    private final TemporalQuery<T> query;

    public AbstractTemporalAccessorConverter(String pattern, TemporalQuery<T> query)
    {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
        this.query = query;
    }

    @Override
    public T convertToObject(String value, Locale locale) throws ConversionException
    {
        if (null == value) {
            return null;
        }

        try {
            return this.formatter.parse(value, this.query);
        } catch (DateTimeParseException e) {
            throw new ConversionException(e);
        }
    }

    @Override
    public String convertToString(T value, Locale locale)
    {
        if (null == value) {
            return null;
        }

        return this.formatter.format(value);
    }
}
