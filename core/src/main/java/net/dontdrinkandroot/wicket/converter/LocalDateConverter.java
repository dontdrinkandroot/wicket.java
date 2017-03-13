package net.dontdrinkandroot.wicket.converter;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.converter.AbstractConverter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Converts between String and {@link LocalDate}.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalDateConverter extends AbstractConverter<LocalDate>
{
    @Override
    public LocalDate convertToObject(String value, Locale locale) throws ConversionException
    {
        try {
            return LocalDate.parse(value);
        } catch (DateTimeParseException e) {
            throw new ConversionException("Invalid format, expecting yyyy-mm-dd", e);
        }
    }

    @Override
    protected Class<LocalDate> getTargetType()
    {
        return LocalDate.class;
    }
}
