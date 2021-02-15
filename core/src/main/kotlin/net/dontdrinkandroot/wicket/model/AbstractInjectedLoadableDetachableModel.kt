package net.dontdrinkandroot.wicket.model

import org.apache.wicket.injection.Injector
import org.apache.wicket.model.LoadableDetachableModel
import java.io.IOException

abstract class AbstractInjectedLoadableDetachableModel<T> : LoadableDetachableModel<T> {
    constructor() : super()
    constructor(value: T) : super(value)

    init {
        Injector.get().inject(this)
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    private fun readObject(stream: java.io.ObjectInputStream) {
        stream.defaultReadObject()
        Injector.get().inject(this)
    }
}