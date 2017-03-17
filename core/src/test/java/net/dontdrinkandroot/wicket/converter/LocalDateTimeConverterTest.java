package net.dontdrinkandroot.wicket.converter;

import org.apache.wicket.util.convert.ConversionException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Locale;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalDateTimeConverterTest
{
    @Test
    public void testConvertToString()
    {
        LocalDateTimeConverter converter = new LocalDateTimeConverter();
        Assert.assertNull(converter.convertToString(null, Locale.ENGLISH));
        Assert.assertEquals(
                "2017-03-05T13:37",
                converter.convertToString(LocalDateTime.of(2017, 3, 5, 13, 37), Locale.ENGLISH)
        );
    }

    @Test
    public void testConvertToObject()
    {
        LocalDateTimeConverter converter = new LocalDateTimeConverter();
        Assert.assertNull(converter.convertToObject(null, Locale.ENGLISH));
        Assert.assertEquals(
                LocalDateTime.of(2017, 3, 5, 13, 37),
                converter.convertToObject("2017-03-05T13:37", Locale.ENGLISH)
        );
        try {
            converter.convertToObject("asdf", Locale.ENGLISH);
            Assert.fail("ConversionException expected");
        } catch (ConversionException e) {
            /* Expected */
        }
    }
}
