package net.dontdrinkandroot.wicket.css

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CompositeCssClassTest {

    @Test
    fun testOneElement() {
        var cssClass: CssClass
        cssClass = CompositeCssClass(StringCssClass("asdf"))
        Assertions.assertEquals("asdf", cssClass.classString)
        cssClass = CompositeCssClass("asdf")
        Assertions.assertEquals("asdf", cssClass.classString)
    }

    @Test
    fun testMultipleElements() {
        var cssClass: CssClass
        cssClass = CompositeCssClass(StringCssClass("asdf"), StringCssClass("qwer"))
        Assertions.assertEquals("asdf qwer", cssClass.classString)
        cssClass = CompositeCssClass("asdf", "qwer")
        Assertions.assertEquals("asdf qwer", cssClass.classString)
    }
}