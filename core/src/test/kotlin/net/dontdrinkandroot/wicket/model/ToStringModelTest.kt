package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ToStringModelTest {

    @Test
    fun testIsReadOnly() {
        val parentModel = Model(LocalDate.of(2012, 1, 2))
        val model: IModel<String> = ToStringModel(parentModel)
        try {
            model.setObject("Test")
            Assertions.fail<Any>("Runtimeexception expected")
        } catch (e: UnsupportedOperationException) {
            Assertions.assertEquals(
                "Model class does not support setObject(Object)",
                e.message
            )
        }
    }
}