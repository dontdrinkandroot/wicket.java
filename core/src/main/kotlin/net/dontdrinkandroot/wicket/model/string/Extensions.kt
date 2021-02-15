package net.dontdrinkandroot.wicket.model.string

import net.dontdrinkandroot.wicket.model.AbstractChainedModel
import org.apache.wicket.model.IModel

fun String.concat(model: IModel<String>): IModel<String> =
    object : AbstractChainedModel<String, String>(model) {
        override fun getValue(parentValue: String?) = this@concat + parentValue
    }