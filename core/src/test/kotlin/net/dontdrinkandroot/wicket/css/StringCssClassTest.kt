package net.dontdrinkandroot.wicket.css

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StringCssClassTest {

    @Test
    fun testGetClassString() {
        val cssClass: CssClass = StringCssClass("test")
        Assertions.assertEquals("test", cssClass.classString)
    }
}