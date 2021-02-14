package net.dontdrinkandroot.wicket.model

import org.apache.wicket.injection.Injector
import org.apache.wicket.model.LoadableDetachableModel

abstract class AbstractInjectedLoadableDetachableModel<T> : LoadableDetachableModel<T> {
    constructor() : super() {
        Injector.get().inject(this)
    }

    constructor(value: T) : super(value) {
        Injector.get().inject(this)
    }
}