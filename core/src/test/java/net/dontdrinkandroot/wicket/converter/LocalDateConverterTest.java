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
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Locale;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalDateConverterTest
{
    @Test
    public void testConvertToString()
    {
        LocalDateConverter converter = new LocalDateConverter();
        Assert.assertNull(converter.convertToString(null, Locale.ENGLISH));
        Assert.assertEquals("2017-03-05", converter.convertToString(LocalDate.of(2017, 3, 5), Locale.ENGLISH));
    }

    @Test
    public void testConvertToObject()
    {
        LocalDateConverter converter = new LocalDateConverter();
        Assert.assertNull(converter.convertToObject(null, Locale.ENGLISH));
        Assert.assertEquals(LocalDate.of(2017, 3, 5), converter.convertToObject("2017-03-05", Locale.ENGLISH));
        try {
            converter.convertToObject("2017-3-5", Locale.ENGLISH);
            Assert.fail("ConversionException expected");
        } catch (ConversionException e) {
            /* Expected */
        }
        try {
            converter.convertToObject("asdf", Locale.ENGLISH);
            Assert.fail("ConversionException expected");
        } catch (ConversionException e) {
            /* Expected */
        }
    }
}
