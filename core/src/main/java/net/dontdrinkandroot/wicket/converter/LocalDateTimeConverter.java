package net.dontdrinkandroot.wicket.converter;

import java.time.LocalDateTime;

/**
 * Converts between String and {@link java.time.LocalDateTime}
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalDateTimeConverter extends AbstractTemporalAccessorConverter<LocalDateTime>
{
    public LocalDateTimeConverter()
    {
        super("yyyy-MM-dd'T'HH:mm", LocalDateTime::from);
    }
}
