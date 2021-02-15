package net.dontdrinkandroot.wicket.bootstrap.css

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FontAwesome4IconClassTest {

    @Test
    fun testGetClassString() {
        for (fontAwesomeIconClass in FontAwesome4IconClass.values()) {
            if (fontAwesomeIconClass != FontAwesome4IconClass.FIVEHUNDRED_PX) {
                Assertions.assertEquals(
                    "fa-" + fontAwesomeIconClass.name.toLowerCase().replace("_", "-"),
                    fontAwesomeIconClass.classString
                )
            }
        }
    }
}