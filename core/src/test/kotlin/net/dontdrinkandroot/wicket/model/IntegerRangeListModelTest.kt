package net.dontdrinkandroot.wicket.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class IntegerRangeListModelTest {

    @Test
    fun testRanges() {
        val model = IntegerRangeListModel(1, 3)
        Assertions.assertEquals(model.getObject(), listOf(1, 2, 3))
        model.min = 2
        Assertions.assertEquals(model.getObject(), listOf(2, 3))
        model.max = 4
        Assertions.assertEquals(model.getObject(), listOf(2, 3, 4))
        Assertions.assertEquals(2, model.min)
        Assertions.assertEquals(4, model.max)
    }
}