package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

fun interface KModel<T> : IModel<T> {

    fun getValue(): T

    fun setValue(value: T) {
        throw UnsupportedOperationException("Override this method to support setValue(value)")
    }

    override fun getObject(): T = getValue()

    override fun setObject(value: T) = setValue(value)
}