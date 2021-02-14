package net.dontdrinkandroot.wicket.converter

import java.time.LocalTime
import java.time.temporal.TemporalAccessor
import java.time.temporal.TemporalQuery

/**
 * Converts between String and [LocalTime]
 */
class LocalTimeConverter : AbstractTemporalAccessorConverter<LocalTime>(
    "HH:mm",
    TemporalQuery { temporal: TemporalAccessor -> LocalTime.from(temporal) })