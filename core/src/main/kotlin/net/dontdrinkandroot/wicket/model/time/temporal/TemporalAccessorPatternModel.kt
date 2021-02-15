package net.dontdrinkandroot.wicket.model.time.temporal

import net.dontdrinkandroot.wicket.model.AbstractChainedModel
import org.apache.wicket.model.IModel
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor
import java.util.*

class TemporalAccessorPatternModel<T : TemporalAccessor>(
    parentModel: IModel<T>,
    private val pattern: String,
    private val locale: Locale = Locale.ENGLISH,
    private val zoneId: ZoneId = ZoneId.from(ZoneOffset.UTC)
) : AbstractChainedModel<T, String>(parentModel) {

    override fun getValue(parentValue: T?) = parentValue?.let {
        DateTimeFormatter.ofPattern(pattern).withLocale(locale).withZone(zoneId).format(it)
    }
}

fun <T : TemporalAccessor> IModel<T>.patternFormat(
    pattern: String,
    locale: Locale = Locale.ENGLISH,
    zoneId: ZoneId = ZoneId.from(ZoneOffset.UTC)
): IModel<String> = TemporalAccessorPatternModel(this, pattern, locale, zoneId)
