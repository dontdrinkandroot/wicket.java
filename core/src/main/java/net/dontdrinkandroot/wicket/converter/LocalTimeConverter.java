package net.dontdrinkandroot.wicket.converter;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Converts between String and {@link LocalTime}
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalTimeConverter implements IConverter<LocalTime>
{
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public LocalTime convertToObject(String value, Locale locale) throws ConversionException
    {
        if (null == value) {
            return null;
        }

        try {
            return LocalTime.parse(value, this.formatter);
        } catch (DateTimeParseException e) {
            throw new ConversionException(e);
        }
    }

    @Override
    public String convertToString(LocalTime value, Locale locale)
    {
        if (null == value) {
            return null;
        }

        return value.format(this.formatter);
    }
}
