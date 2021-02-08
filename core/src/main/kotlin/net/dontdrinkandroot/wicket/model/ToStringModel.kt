package net.dontdrinkandroot.wicket.model

/**
 * [ChainedModel] that simply returns the toString() result of the parent object.
 */
class ToStringModel(parent: KModel<out Any>) : AbstractChainedModel<Any, String>(parent) {

    override fun getValue(parentValue: Any) = parentValue.toString()
}