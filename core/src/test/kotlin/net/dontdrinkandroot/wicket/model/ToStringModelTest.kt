package net.dontdrinkandroot.wicket.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ToStringModelTest {

    @Test
    fun testIsReadOnly() {
        val parentModel = LocalDate.of(2012, 1, 2).kModel()
        val model: KModel<String> = ToStringModel(parentModel)
        try {
            model.setObject("Test")
            Assertions.fail<Any>("Runtimeexception expected")
        } catch (e: UnsupportedOperationException) {
            Assertions.assertEquals(
                "Model class net.dontdrinkandroot.wicket.model.ToStringModel does not support setObject(Object)",
                e.message
            )
        }
    }
}