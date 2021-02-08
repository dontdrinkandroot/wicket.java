package net.dontdrinkandroot.wicket.model

interface ChainedModel<P, T> : KModel<T>

abstract class AbstractChainedModel<P, T>(protected val parent: KModel<out P>) : ChainedModel<P, T> {

    override fun getValue(): T = this.getValue(parent.getValue())

    abstract fun getValue(parentValue: P): T

    override fun detach() {
        this.parent.detach()
    }
}

fun <P, T> KModel<P>.chain(getChain: (P) -> T, setChain: (P, T) -> Unit = { _: P, _: T -> }): KModel<T> =
    object : AbstractChainedModel<P, T>(this) {
        override fun getValue(parentValue: P): T = getChain(parentValue)
        override fun setValue(value: T) = setChain(this.parent.getValue(), value)
    }
