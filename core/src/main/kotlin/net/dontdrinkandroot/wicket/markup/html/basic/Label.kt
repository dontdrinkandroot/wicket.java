package net.dontdrinkandroot.wicket.markup.html.basic

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class Label<T>(
    id: String,
    model: IModel<T>? = null,
    private val visibleModel: IModel<Boolean> = Model(true)
) : Label(id, model) {

    override fun isVisible(): Boolean = super.isVisible() && false != visibleModel.getObject()

    override fun detachModels() {
        super.detachModels()
        visibleModel.detach()
    }
}
