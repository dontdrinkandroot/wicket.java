package net.dontdrinkandroot.wicket.converter

import java.time.LocalDate
import java.time.temporal.TemporalAccessor
import java.time.temporal.TemporalQuery

/**
 * Converts between String and [LocalDate].
 */
class LocalDateConverter : AbstractTemporalAccessorConverter<LocalDate>(
    "yyyy-MM-dd",
    TemporalQuery { temporal: TemporalAccessor -> LocalDate.from(temporal) })