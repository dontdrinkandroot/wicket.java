package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

/**
 * Returns the name of an enum Model in lower case or null if not set.
 */
class EnumLowerCaseNameModel(parent: IModel<out Enum<*>>) : AbstractChainedModel<Enum<*>, String>(parent) {

    override fun getValue(parentValue: Enum<*>?): String? = parentValue?.name?.toLowerCase()
}