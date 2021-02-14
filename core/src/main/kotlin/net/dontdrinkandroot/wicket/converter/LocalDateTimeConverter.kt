package net.dontdrinkandroot.wicket.converter

import java.time.LocalDateTime
import java.time.temporal.TemporalAccessor
import java.time.temporal.TemporalQuery

/**
 * Converts between String and [java.time.LocalDateTime]
 */
class LocalDateTimeConverter : AbstractTemporalAccessorConverter<LocalDateTime>(
    "yyyy-MM-dd'T'HH:mm",
    TemporalQuery { temporal: TemporalAccessor -> LocalDateTime.from(temporal) })