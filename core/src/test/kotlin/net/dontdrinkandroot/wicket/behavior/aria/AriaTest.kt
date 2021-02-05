package net.dontdrinkandroot.wicket.behavior.aria

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AriaTest {

    @Test
    fun testNaming() {
        val ariaValues = Aria.values()
        Assertions.assertEquals(35, ariaValues.size)
        for (aria in ariaValues) {
            Assertions.assertEquals("aria-" + aria.name.toLowerCase(), aria.attribute)
        }
    }
}