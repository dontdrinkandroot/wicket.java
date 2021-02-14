package net.dontdrinkandroot.wicket.converter

import org.apache.wicket.util.convert.ConversionException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.*

class LocalDateConverterTest {

    @Test
    fun testConvertToString() {
        val converter = LocalDateConverter()
        Assertions.assertNull(converter.convertToString(null, Locale.ENGLISH))
        Assertions.assertEquals("2017-03-05", converter.convertToString(LocalDate.of(2017, 3, 5), Locale.ENGLISH))
    }

    @Test
    fun testConvertToObject() {
        val converter = LocalDateConverter()
        Assertions.assertNull(converter.convertToObject(null, Locale.ENGLISH))
        Assertions.assertEquals(LocalDate.of(2017, 3, 5), converter.convertToObject("2017-03-05", Locale.ENGLISH))
        try {
            converter.convertToObject("2017-3-5", Locale.ENGLISH)
            Assertions.fail<Any>("ConversionException expected")
        } catch (e: ConversionException) {
            /* Expected */
        }
        try {
            converter.convertToObject("asdf", Locale.ENGLISH)
            Assertions.fail<Any>("ConversionException expected")
        } catch (e: ConversionException) {
            /* Expected */
        }
    }
}