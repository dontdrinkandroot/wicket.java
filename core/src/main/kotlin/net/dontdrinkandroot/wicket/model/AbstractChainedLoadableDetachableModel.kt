package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import org.apache.wicket.model.LoadableDetachableModel

abstract class AbstractChainedLoadableDetachableModel<P, T>(protected val parent: IModel<out P?>) :
    LoadableDetachableModel<T>() {

    override fun setObject(value: T) {
        throw RuntimeException("Chained Model, cannot set Object, must override method in order to do so")
    }

    override fun load(): T? = load(parent.getObject())

    abstract fun load(parentValue: P?): T?
}