package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

interface ChainedModel<P, T> : IModel<T?> {

    fun getParentModel(): IModel<P?>

    fun getParentModelObject(): P? = getParentModel().`object`
}

interface ChainedReadonlyModel<P, T> : IModel<T?> {

    fun getParentModel(): IModel<out P?>

    fun getParentModelObject(): P? = getParentModel().`object`
}

abstract class AbstractChainedModel<P, T>(private val parentModel: IModel<P?>) : ChainedModel<P, T> {

    override fun getParentModel(): IModel<P?> {
        return this.parentModel
    }

    override fun detach() {
        this.getParentModel().detach()
    }
}

fun <P, T> IModel<P?>.chain(getChain: (P?) -> T?, setChain: (P?, T?) -> Unit): IModel<T?> =
    object : AbstractChainedModel<P, T>(this) {
        override fun getObject(): T? = getChain(getParentModel().`object`)
        override fun setObject(value: T?) {
            setChain(getParentModelObject(), value)
        }
    }

abstract class AbstractChainedReadonlyModel<P, T>(private val parentModel: IModel<out P?>) :
    ChainedReadonlyModel<P, T> {

    override fun getParentModel(): IModel<out P?> {
        return this.parentModel
    }

    override fun detach() {
        this.getParentModel().detach()
    }

    final override fun setObject(`object`: T?) {
        super.setObject(`object`)
    }
}

fun <P, T> IModel<P?>.chain(chain: (P?) -> T?): IModel<T?> = object : AbstractChainedReadonlyModel<P, T>(this) {
    override fun getObject(): T? = chain(getParentModel().`object`)
}