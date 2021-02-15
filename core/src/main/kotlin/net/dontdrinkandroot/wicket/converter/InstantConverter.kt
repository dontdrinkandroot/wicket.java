package net.dontdrinkandroot.wicket.converter

import org.apache.wicket.util.convert.converter.AbstractJavaTimeConverter
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor

class InstantConverter(private val zoneId: ZoneId) : AbstractJavaTimeConverter<Instant>() {

    override fun getTargetType(): Class<Instant> = Instant::class.java

    override fun createTemporal(temporalAccessor: TemporalAccessor?): Instant? =
        temporalAccessor?.run { Instant.from(temporalAccessor) }

    override fun getDateTimeFormatter(): DateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(zoneId)
}
