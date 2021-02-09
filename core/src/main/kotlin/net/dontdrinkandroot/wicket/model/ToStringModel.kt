package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

/**
 * [ChainedModel] that simply returns the toString() result of the parent object.
 */
class ToStringModel(parent: IModel<out Any>) : AbstractChainedModel<Any, String>(parent) {

    override fun getValue(parentValue: Any?) = parentValue.toString()
}