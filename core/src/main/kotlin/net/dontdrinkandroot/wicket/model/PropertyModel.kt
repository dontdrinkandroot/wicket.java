package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import kotlin.reflect.KFunction1
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

class MutablePropertyModel<P, T>(parentModel: IModel<P>, private val property: KMutableProperty1<P, T>) :
    AbstractChainedModel<P, T>(parentModel) {

    override fun getValue(parentValue: P?): T? = parentValue?.let { property.get(it) }

    override fun setObject(value: T) {
        val parentModelObject = this.parent.getObject() ?: throw RuntimeException("Parent Model Object was null")
        /* This will lead to an exception if value is null and property is not nullable */
        @Suppress("UNCHECKED_CAST")
        property.set(parentModelObject, value)
    }
}

fun <P, T> IModel<T>.writableProperty(property: KMutableProperty1<T, P>): IModel<P> =
    MutablePropertyModel(this, property)

class PropertyModel<P, T>(parentModel: IModel<P>, private val property: KProperty1<P, T?>) :
    AbstractChainedModel<P, T>(parentModel) {

    override fun getValue(parentValue: P?): T? = parentValue?.let { property.get(it) }
}

fun <P, T> IModel<T>.property(property: KProperty1<T, P?>): IModel<P> = PropertyModel(this, property)

fun <P, T> IModel<P>.function(function: KFunction1<P, T>): IModel<T> = object : AbstractChainedModel<P, T>(this) {
    override fun getValue(parentValue: P?): T? = parentValue?.let { function.invoke(it) }
}