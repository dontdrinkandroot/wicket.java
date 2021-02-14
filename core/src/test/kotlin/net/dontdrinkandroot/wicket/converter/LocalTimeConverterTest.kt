package net.dontdrinkandroot.wicket.converter

import org.apache.wicket.util.convert.ConversionException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalTime
import java.util.*

class LocalTimeConverterTest {

    @Test
    fun testConvertToString() {
        val converter = LocalTimeConverter()
        Assertions.assertNull(converter.convertToString(null, Locale.ENGLISH))
        Assertions.assertEquals("12:34", converter.convertToString(LocalTime.of(12, 34), Locale.ENGLISH))
        Assertions.assertEquals("12:34", converter.convertToString(LocalTime.of(12, 34, 56), Locale.ENGLISH))
    }

    @Test
    fun testConvertToObject() {
        val converter = LocalTimeConverter()
        Assertions.assertNull(converter.convertToObject(null, Locale.ENGLISH))
        Assertions.assertEquals(LocalTime.of(12, 34), converter.convertToObject("12:34", Locale.ENGLISH))
        try {
            converter.convertToObject("12:34:56", Locale.ENGLISH)
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