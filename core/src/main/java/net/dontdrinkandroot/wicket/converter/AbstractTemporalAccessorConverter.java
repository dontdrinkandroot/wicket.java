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
