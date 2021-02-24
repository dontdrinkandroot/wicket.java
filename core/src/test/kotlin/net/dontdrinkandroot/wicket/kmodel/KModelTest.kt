package net.dontdrinkandroot.wicket.kmodel

import net.dontdrinkandroot.wicket.model.value
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.Serializable

class KModelTest {

    private data class ExampleObject(val id: Int, var name: String, var age: Int?) : Serializable

    @Test
    fun testKProperty() {
        val exampleObject = ExampleObject(666, "Name", 39)

        val parentModel: KModel<ExampleObject> = ValueKModel(exampleObject)

        val idModel: KModel<Int> = parentModel.property(ExampleObject::id)
        Assertions.assertEquals(666, idModel.value)

        val nameModel: KModel<String> = parentModel.property(ExampleObject::name)
        Assertions.assertEquals("Name", nameModel.value)

        val ageModel: KModel<Int?> = parentModel.property(ExampleObject::age)
        Assertions.assertEquals(39, ageModel.value)
    }

    @Test
    fun testWritableKProperty() {

        val exampleObject = ExampleObject(666, "Name", 39)

        val parentModel: KModel<ExampleObject> = ValueKModel(exampleObject)

        val nameModel: WriteableKModel<String> = parentModel.writableProperty(ExampleObject::name)
        Assertions.assertEquals("Name", nameModel.value)
        nameModel.value = "ChangedName"
        Assertions.assertEquals("ChangedName", nameModel.value)
        Assertions.assertEquals("ChangedName", nameModel.getObject())
        Assertions.assertEquals("ChangedName", exampleObject.name)

        val ageModel: WriteableKModel<Int?> = parentModel.writableProperty(ExampleObject::age)
        Assertions.assertEquals(39, ageModel.value)
        ageModel.value = null
        Assertions.assertEquals(null, ageModel.value)
        Assertions.assertEquals(null, ageModel.getObject())
        Assertions.assertEquals(null, exampleObject.age)

        val nullParentModel: KModel<ExampleObject?> = ValueKModel(null)

        Assertions.assertNull(nullParentModel.optionalProperty(ExampleObject::id).value)
    }

    @Test
    fun testModelExtension() {
        val nonNullableModel: KModel<String> = "value".kModel()
        Assertions.assertEquals("value", nonNullableModel.getObject())
        //nonNullable.setObject(null) // Expected not to compile
        //val nonNullableWithNull: IModel<String> = null.model() // Expected not to compile
        val nullableModel: KModel<String?> = "value".kModel()
        Assertions.assertEquals("value", nullableModel.getObject())
        nullableModel.setObject(null)
        val nullableWithNullModel: IModel<String?> = null.kModel()
        Assertions.assertNull(nullableWithNullModel.value)
    }

    @Test
    fun testWrap() {
        val iModel: IModel<String> = Model("value")
        val kModel: WriteableKModel<String> = iModel.wrap()
        Assertions.assertEquals("value", iModel.getObject())
        Assertions.assertEquals("value", kModel.value)
        iModel.setObject("ChangeOne")
        Assertions.assertEquals("ChangeOne", iModel.getObject())
        Assertions.assertEquals("ChangeOne", kModel.value)
        kModel.value = "ChangeTwo"
        Assertions.assertEquals("ChangeTwo", iModel.getObject())
        Assertions.assertEquals("ChangeTwo", kModel.value)

        /* Unsafe null */
        iModel.setObject(null)
        Assertions.assertNull(iModel.getObject())
        Assertions.assertNull(kModel.value)
    }
}