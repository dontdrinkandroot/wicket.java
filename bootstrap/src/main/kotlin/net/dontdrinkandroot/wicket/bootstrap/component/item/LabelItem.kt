package net.dontdrinkandroot.wicket.bootstrap.component.item

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel

open class LabelItem(id: String, model: IModel<String>) : Label(id, model), LabeledItem {

    override fun getLabel(): IModel<String> {
        @Suppress("UNCHECKED_CAST")
        return this.defaultModel as IModel<String>
    }
}