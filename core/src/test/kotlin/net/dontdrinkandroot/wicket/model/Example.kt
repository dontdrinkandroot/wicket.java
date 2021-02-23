package net.dontdrinkandroot.wicket.model

interface Model<T> {

    var value: T
}

class SimpleModel<T>(override var value: T) : Model<T>
class ModelPrinter(val model: Model<String?>) {

    fun print() {
        if (null == model.value) println("NULL") else println(model.value)
    }
}

fun main() {
    val nullableModel: Model<String?> = SimpleModel(null)
    val nonNullableModel: Model<String> = SimpleModel("value")
    ModelPrinter(nullableModel).print()
    //ModelPrinter(nonNullableModel).print() // Does not work
}