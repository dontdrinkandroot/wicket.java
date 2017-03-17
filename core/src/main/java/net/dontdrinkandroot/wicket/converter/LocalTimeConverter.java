package net.dontdrinkandroot.wicket.converter;

import java.time.LocalTime;

/**
 * Converts between String and {@link LocalTime}
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalTimeConverter extends AbstractTemporalAccessorConverter
{
    public LocalTimeConverter()
    {
        super("HH:mm", LocalTime::from);
    }
}
