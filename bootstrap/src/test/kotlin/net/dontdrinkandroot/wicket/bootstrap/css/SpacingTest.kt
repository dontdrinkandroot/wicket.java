package net.dontdrinkandroot.wicket.bootstrap.css

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SpacingTest {

    @Test
    fun testClassStrings() {
        Assertions.assertEquals("m-0", Spacing(Spacing.Property.MARGIN, Spacing.Size.NONE).classString)
        Assertions.assertEquals(
            "pb-lg-5",
            Spacing(Spacing.Property.PADDING, Spacing.Size.THRICE, Spacing.Side.BOTTOM, Breakpoint.LARGE).classString
        )
    }
}