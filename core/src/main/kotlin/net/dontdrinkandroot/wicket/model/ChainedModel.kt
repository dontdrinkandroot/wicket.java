package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

abstract class AbstractChainedModel<P, T>(protected val parent: IModel<out P?>) : IModel<T> {

    final override fun getObject(): T? = this.getValue(parent.getObject())

    abstract fun getValue(parentValue: P?): T?

    override fun detach() {
        this.parent.detach()
    }
}

fun <P, T> IModel<P>.chain(getChain: (P?) -> T, setChain: (P?, T?) -> Unit = { _: P?, _: T? -> }): IModel<T> =
    object : AbstractChainedModel<P, T>(this) {
        override fun getValue(parentValue: P?): T = getChain(parentValue)
        override fun setObject(value: T?) = setChain(this.parent.getObject(), value)
    }
