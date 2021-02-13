package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

interface KModel<T> : IModel<T> {

    var value: T

    override fun getObject(): T = value
    override fun setObject(`object`: T) {
        this.value = `object`
    }
}

class BasicKModel<T>(override var value: T) : KModel<T>

fun <T> print(model: KModel<T>) {
    println(model.value)
}

fun main(args: Array<String>) {
    val nullableModel: KModel<String?> = BasicKModel(null)
    val nonNullableModel: KModel<String> = BasicKModel("value")
    print(nullableModel)
    print(nonNullableModel)
}