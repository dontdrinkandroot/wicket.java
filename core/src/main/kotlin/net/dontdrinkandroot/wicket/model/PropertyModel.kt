package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

class MutablePropertyModel<P, T>(parentModel: IModel<P?>, private val property: KMutableProperty1<P, T>) :
    AbstractChainedModel<P, T?>(parentModel) {

    override fun getObject(): T? {
        return getParentModelObject()?.let { property.get(it) }
    }

    override fun setObject(value: T?) {
        val parentModelObject = getParentModelObject() ?: throw RuntimeException("Parent Model Object was null")
        /* This will lead to an exception if value is null and property is not nullable */
        @Suppress("UNCHECKED_CAST")
        (property as KMutableProperty1<P, T?>).set(parentModelObject, value)
    }
}

fun <T, P> IModel<T?>.writableProperty(property: KMutableProperty1<T, P>): IModel<P?> {
    return MutablePropertyModel(this, property)
}

class PropertyModel<P, T>(parentModel: IModel<P?>, private val property: KProperty1<P, T?>) :
    AbstractChainedReadonlyModel<P?, T?>(parentModel) {

    override fun getObject(): T? {
        return getParentModelObject()?.let { property.get(it) }
    }
}

fun <T, P> IModel<T?>.property(property: KProperty1<T, P>): IModel<P?> {
    return PropertyModel(this, property)
}
