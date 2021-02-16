package net.dontdrinkandroot.wicket.model

import org.apache.wicket.IGenericComponent
import org.apache.wicket.markup.Markup
import org.apache.wicket.markup.html.GenericWebMarkupContainer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.Serializable
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

private val <T, C : IGenericComponent<T, *>> IGenericComponent<T, C>.kModel: KModel<T>
    get() = when (this.model) {
        is KModel -> this.model as KModel<T>
        else -> WrappedKModel<T>(this.model)
    }

class KModelTest {

    private data class ExampleObject(val id: Int, var name: String, var age: Int?) : Serializable

    private class WebMarkupContainer<T>(id: String, model: KModel<T>) : GenericWebMarkupContainer<T>(id, model) {

        override fun getAssociatedMarkup(): Markup {
            this.kModel.value?.let { println(it) }
            return super.getAssociatedMarkup()
        }
    }

    fun <T> print(model: KModel<T>) {
        if (null == model.value) println("NULL") else println(model.value)
    }

    @Test
    fun test() {
        val nullableModel: KModel<String?> = BasicKModel(null)
        val nonNullableModel: KModel<String> = BasicKModel("value")
        print(nullableModel)
        print(nonNullableModel)

        val exampleObject = ExampleObject(666, "Name", 39)

        val parentModel: KModel<ExampleObject> = BasicKModel(exampleObject)

        val idModel: KModel<Int> = parentModel.kProperty(ExampleObject::id)
        Assertions.assertEquals(666, idModel.value)

        val nameModel: KModel<String> = parentModel.kProperty(ExampleObject::name)
        Assertions.assertEquals("Name", nameModel.value)

        val ageModel: KModel<Int?> = parentModel.kProperty(ExampleObject::age)
        Assertions.assertEquals(39, ageModel.value)

        val cont1 = WebMarkupContainer("bla", idModel)
        val cont2 = WebMarkupContainer("bla", ageModel)

        val writableNameModel: KModel<String> = parentModel.writableKProperty(ExampleObject::name)
        writableNameModel.value = "ChangedName"
        Assertions.assertEquals("ChangedName", nameModel.value)
        Assertions.assertEquals("ChangedName", nameModel.getObject())
        Assertions.assertEquals("ChangedName", exampleObject.name)

        val writableAgeModel: KModel<Int?> = parentModel.writableKProperty(ExampleObject::age)
        writableAgeModel.value = null
        Assertions.assertEquals(null, ageModel.value)
        Assertions.assertEquals(null, ageModel.getObject())
        Assertions.assertEquals(null, exampleObject.age)

        val nullParentModel: KModel<ExampleObject?> = BasicKModel(null)

        Assertions.assertNull(nullParentModel.optionalKProperty(ExampleObject::id).value)
    }

    private fun <T, P> KModel<T>.writableKProperty(kMutableProperty1: KMutableProperty1<T, P>): KModel<P> =
        object : KModel<P> {
            override var value: P
                get() = kMutableProperty1.getValue(this@writableKProperty.value, kMutableProperty1)
                set(value) = kMutableProperty1.set(this@writableKProperty.value, value)

            override fun detach() {
                this@writableKProperty.detach()
            }
        }

    private fun <T, P> KModel<T>.kProperty(kProperty1: KProperty1<T, P>): KModel<P> = object : KModel<P> {
        override var value: P
            get() = kProperty1.getValue(this@kProperty.value, kProperty1)
            set(value) = throw UnsupportedOperationException("Readonly")

        override fun detach() {
            this@kProperty.detach()
        }
    }

    private fun <T, P> KModel<T?>.optionalKProperty(kProperty1: KProperty1<T, P>): KModel<P?> = object : KModel<P?> {
        override var value: P?
            get() = this@optionalKProperty.value?.let { kProperty1.getValue(it, kProperty1) }
            set(value) = throw UnsupportedOperationException("Readonly")

        override fun detach() {
            this@optionalKProperty.detach()
        }
    }
}