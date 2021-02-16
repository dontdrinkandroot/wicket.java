package net.dontdrinkandroot.wicket.bootstrap.component.item

import org.apache.wicket.model.IModel

/**
 * [AbstractItem] that contains a Text.
 */
open class AbstractLabeledItem<T> constructor(
    id: String,
    model: IModel<T>? = null,
    private val labelModel: IModel<String>
) : AbstractItem<T>(id, model), LabeledItem {

    override fun getLabel() = labelModel
}
