package net.dontdrinkandroot.wicket.markup.html.link

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import net.dontdrinkandroot.wicket.markup.html.link.Link as DdrLink

open class Link<T>(
    id: String,
    model: IModel<T>? = null,
    private val visibleModel: IModel<Boolean> = Model(true),
    private val enabledModel: IModel<Boolean> = Model(true),
    behaviors: Collection<Behavior> = emptyList(),
    bodyModel: IModel<String> = Model(null),
    private val onClickHandler: (context: DdrLink<T>) -> Any?
) : Link<T>(id, model) {

    init {
        body = bodyModel
        behaviors.forEach { this.add(it) }
    }

    final override fun onClick() {
        onClickHandler(this)
    }

    override fun isVisible(): Boolean = super.isVisible() && false != visibleModel.getObject()

    override fun isEnabled(): Boolean = super.isEnabled() && false != enabledModel.getObject()

    override fun detachModels() {
        super.detachModels()
        visibleModel.detach()
        enabledModel.detach()
    }
}