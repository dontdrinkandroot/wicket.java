package net.dontdrinkandroot.wicket.converter;

import java.time.LocalDate;

/**
 * Converts between String and {@link LocalDate}.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalDateConverter extends AbstractTemporalAccessorConverter<LocalDate>
{
    public LocalDateConverter()
    {
        super("yyyy-MM-dd", LocalDate::from);
    }
}
