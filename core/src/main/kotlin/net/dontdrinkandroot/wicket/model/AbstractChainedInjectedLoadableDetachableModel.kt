package net.dontdrinkandroot.wicket.model

import org.apache.wicket.injection.Injector
import org.apache.wicket.model.IModel
import java.io.IOException

abstract class AbstractChainedInjectedLoadableDetachableModel<P, T>(parent: IModel<out P>) :
    AbstractChainedLoadableDetachableModel<P, T>(parent) {

    init {
        Injector.get().inject(this)
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    private fun readObject(stream: java.io.ObjectInputStream) {
        stream.defaultReadObject()
        Injector.get().inject(this)
    }
}