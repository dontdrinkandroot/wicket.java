package net.dontdrinkandroot.wicket.converter

import org.apache.wicket.util.convert.ConversionException
import org.apache.wicket.util.convert.IConverter
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.TemporalAccessor
import java.time.temporal.TemporalQuery
import java.util.*

/**
 * Converts between String and a [TemporalAccessor]
 */
open class AbstractTemporalAccessorConverter<T : TemporalAccessor>(
    pattern: String,
    private val query: TemporalQuery<T>
) :
    IConverter<T> {

    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(pattern)

    @Throws(ConversionException::class)
    override fun convertToObject(value: String?, locale: Locale): T? {
        return if (null == value) {
            null
        } else try {
            formatter.parse(value, query)
        } catch (e: DateTimeParseException) {
            throw ConversionException(e)
        }
    }

    override fun convertToString(value: T?, locale: Locale): String? = when (value) {
        null -> null
        else -> formatter.format(value)
    }
}