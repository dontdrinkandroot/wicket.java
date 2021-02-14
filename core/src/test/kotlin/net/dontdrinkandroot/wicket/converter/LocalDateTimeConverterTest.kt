package net.dontdrinkandroot.wicket.converter

import org.apache.wicket.util.convert.ConversionException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*

class LocalDateTimeConverterTest {

    @Test
    fun testConvertToString() {
        val converter = LocalDateTimeConverter()
        Assertions.assertNull(converter.convertToString(null, Locale.ENGLISH))
        Assertions.assertEquals(
            "2017-03-05T13:37",
            converter.convertToString(LocalDateTime.of(2017, 3, 5, 13, 37), Locale.ENGLISH)
        )
    }

    @Test
    fun testConvertToObject() {
        val converter = LocalDateTimeConverter()
        Assertions.assertNull(converter.convertToObject(null, Locale.ENGLISH))
        Assertions.assertEquals(
            LocalDateTime.of(2017, 3, 5, 13, 37),
            converter.convertToObject("2017-03-05T13:37", Locale.ENGLISH)
        )
        try {
            converter.convertToObject("asdf", Locale.ENGLISH)
            Assertions.fail<Any>("ConversionException expected")
        } catch (e: ConversionException) {
            /* Expected */
        }
    }
}