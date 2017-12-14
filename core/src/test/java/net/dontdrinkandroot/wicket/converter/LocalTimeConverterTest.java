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

import java.time.LocalTime;
import java.util.Locale;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalTimeConverterTest
{
    @Test
    public void testConvertToString()
    {
        LocalTimeConverter converter = new LocalTimeConverter();
        Assert.assertNull(converter.convertToString(null, Locale.ENGLISH));
        Assert.assertEquals("12:34", converter.convertToString(LocalTime.of(12, 34), Locale.ENGLISH));
        Assert.assertEquals("12:34", converter.convertToString(LocalTime.of(12, 34, 56), Locale.ENGLISH));
    }

    @Test
    public void testConvertToObject()
    {
        LocalTimeConverter converter = new LocalTimeConverter();
        Assert.assertNull(converter.convertToObject(null, Locale.ENGLISH));
        Assert.assertEquals(LocalTime.of(12, 34), converter.convertToObject("12:34", Locale.ENGLISH));
        try {
            converter.convertToObject("12:34:56", Locale.ENGLISH);
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
