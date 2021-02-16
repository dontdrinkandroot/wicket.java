package net.dontdrinkandroot.wicket.markup.html

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.GenericWebMarkupContainer
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

open class WebMarkupContainer<T>(
    id: String,
    model: IModel<T>? = null,
    private val visibleModel: IModel<Boolean> = Model(true),
    private val enabledModel: IModel<Boolean> = Model(true),
    behaviors: Collection<Behavior> = emptyList(),
) : GenericWebMarkupContainer<T>(id, model) {

    override fun isVisible(): Boolean = super.isVisible() && false != visibleModel.getObject()

    init {
        behaviors.forEach { this.add(it) }
    }

    override fun detachModels() {
        super.detachModels()
        visibleModel.detach()
        enabledModel.detach()
    }
}
