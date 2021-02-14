package net.dontdrinkandroot.wicket.bootstrap.css.grid

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ColumnOffsetStackTest {

    @Test
    fun testGetInverseColumnSize() {
        val stack = ColumnOffsetStack(
            ColumnOffsetDefault.COLUMNS_2,
            ColumnOffsetSmall.COLUMNS_3,
            ColumnOffsetMedium.COLUMNS_4,
            ColumnOffsetLarge.COLUMNS_5
        )
        val inverseStack = stack.inverseColumnSize
        Assertions.assertEquals("col-10 col-sm-9 col-md-8 col-lg-7", inverseStack.classString)
    }

    @Test
    fun getInverseColumnOffset() {
        val stack = ColumnOffsetStack(
            ColumnOffsetDefault.COLUMNS_2,
            ColumnOffsetSmall.COLUMNS_3,
            ColumnOffsetMedium.COLUMNS_4,
            ColumnOffsetLarge.COLUMNS_5
        )
        val inverseStack = stack.inverseColumnOffset
        Assertions.assertEquals(
            "offset-10 offset-sm-9 offset-md-8 offset-lg-7",
            inverseStack.classString
        )
    }
}