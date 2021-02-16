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

class WrappedKModel<T>(private val model: IModel<T>) : KModel<T> {

    override var value: T
        get() = model.getObject()
        set(value) {
            model.setObject(value)
        }
}