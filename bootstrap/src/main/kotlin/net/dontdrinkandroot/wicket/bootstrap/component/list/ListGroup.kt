package net.dontdrinkandroot.wicket.bootstrap.component.list

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.AbstractList
import net.dontdrinkandroot.wicket.component.basic.UnorderedList
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object.
 */
open class ListGroup<T>(
    id: String,
    model: IModel<List<T>>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    createItemHandler: AbstractList<T>.(id: String, model: IModel<T>) -> Component
) : UnorderedList<T>(id, model, behaviors, createItemHandler) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.LIST_GROUP))
    }

    override fun processListComponent(listComponent: Component) {
        super.processListComponent(listComponent)
        listComponent.add(CssClassAppender(BootstrapCssClass.LIST_GROUP_ITEM))
    }
}