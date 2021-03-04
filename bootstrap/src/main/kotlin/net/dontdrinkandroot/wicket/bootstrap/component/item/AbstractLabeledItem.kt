package net.dontdrinkandroot.wicket.bootstrap.component.item

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

/**
 * [AbstractItem] that contains a Text.
 */
open class AbstractLabeledItem<T> constructor(
    id: String,
    model: IModel<T>? = null,
    private val labelModel: IModel<String>,
    vararg behaviors: Behavior,
) : AbstractItem<T>(id, model, *behaviors), LabeledItem {

    override fun getLabel() = labelModel
}