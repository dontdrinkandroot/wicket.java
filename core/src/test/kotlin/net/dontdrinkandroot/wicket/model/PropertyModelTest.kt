package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.Serializable

class PropertyModelTest {
    private inner class ExampleObject(val id: Int, var name: String, var age: Int?) : Serializable

    @Test
    fun testProperty() {
        val parentModel: IModel<ExampleObject> = Model(ExampleObject(666, "Name", 39))
        val idModel: IModel<Int> = parentModel.property(ExampleObject::id)
        Assertions.assertEquals(666, idModel.value)
        val nameModel: IModel<String> = parentModel.property(ExampleObject::name)
        Assertions.assertEquals("Name", nameModel.value)
        val ageModel: IModel<Int> = parentModel.property(ExampleObject::age)
        Assertions.assertEquals(39, ageModel.value)
    }
}