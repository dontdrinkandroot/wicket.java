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
