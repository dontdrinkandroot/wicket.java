package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import org.apache.wicket.model.PropertyModel
import kotlin.reflect.KFunction1
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

fun <P, T> IModel<P>.writeableProperty(property: KMutableProperty1<P, T>): IModel<T> =
    PropertyModel(this, property.name)

fun <P, T> IModel<P>.property(property: KProperty1<P, T?>): IModel<T> = object : PropertyModel<T>(this, property.name) {
    override fun setObject(value: T) =
        throw UnsupportedOperationException("Readonly property model, use writeableProperty() instead")
}

fun <P, T> IModel<P>.function(function: KFunction1<P, T>): IModel<T> = object : AbstractChainedModel<P, T>(this) {
    override fun getValue(parentValue: P?): T? = parentValue?.let { function.invoke(it) }
}