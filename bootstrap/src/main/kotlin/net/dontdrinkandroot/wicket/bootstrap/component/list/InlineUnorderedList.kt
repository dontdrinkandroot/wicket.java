package net.dontdrinkandroot.wicket.bootstrap.component.list

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.UnorderedList
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object.
 */
class InlineUnorderedList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    private val createListComponentHandler: (context: InlineUnorderedList<T>, id: String, model: IModel<T>) -> Component
) : UnorderedList<T>(id, model, behaviors) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.LIST_INLINE))
    }

    override fun processListComponent(listComponent: Component) {
        listComponent.add(CssClassAppender(BootstrapCssClass.LIST_INLINE_ITEM))
    }

    override fun createListComponent(id: String, model: IModel<T>) = createListComponentHandler(this, id, model)
}