package net.dontdrinkandroot.wicket.model

import org.apache.wicket.injection.Injector
import org.apache.wicket.model.IModel
import org.apache.wicket.model.LoadableDetachableModel
import java.io.IOException

abstract class AbstractChainedInjectedLoadableDetachableModel<P, T>(protected val parent: IModel<out P>) :
    LoadableDetachableModel<T>() {

    init {
        Injector.get().inject(this)
    }

    override fun detach() {
        super.detach()
        parent.detach()
    }

    override fun setObject(value: T) {
        throw RuntimeException("Chained Model, cannot set Object, must override method in order to do so")
    }

    override fun load(): T? = load(parent.getObject())

    abstract fun load(parentValue: P?): T?

    @Throws(IOException::class, ClassNotFoundException::class)
    private fun readObject(stream: java.io.ObjectInputStream) {
        stream.defaultReadObject()
        Injector.get().inject(this)
    }
}
