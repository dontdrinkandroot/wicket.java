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
