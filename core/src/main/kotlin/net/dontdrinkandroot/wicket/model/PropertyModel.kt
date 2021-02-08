package net.dontdrinkandroot.wicket.model

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

class MutablePropertyModel<P, T>(parentModel: KModel<P>, private val property: KMutableProperty1<P, T>) :
    AbstractChainedModel<P, T>(parentModel) {

    override fun getValue(parentValue: P): T = property.get(parentValue)

    override fun setValue(value: T) {
        val parentModelObject = this.parent.getValue() ?: throw RuntimeException("Parent Model Object was null")
        /* This will lead to an exception if value is null and property is not nullable */
        @Suppress("UNCHECKED_CAST")
        property.set(parentModelObject, value)
    }
}

fun <T, P> KModel<T>.writableProperty(property: KMutableProperty1<T, P>): KModel<P> =
    MutablePropertyModel(this, property)

class PropertyModel<P, T>(parentModel: KModel<P>, private val property: KProperty1<P, T>) :
    AbstractChainedModel<P, T>(parentModel) {

    override fun getValue(parentValue: P): T = property.get(parentValue)
}

fun <T, P> KModel<T>.property(property: KProperty1<T, P>) = PropertyModel(this, property)
