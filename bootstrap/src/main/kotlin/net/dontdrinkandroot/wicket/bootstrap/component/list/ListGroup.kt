package net.dontdrinkandroot.wicket.bootstrap.component.list

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.UnorderedList
import org.apache.wicket.Component
import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

abstract class ListGroup<T>(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
) : UnorderedList<T>(id, model, *behaviors) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.LIST_GROUP))
    }

    override fun processListComponent(listComponent: Component) {
        super.processListComponent(listComponent)
        listComponent.add(CssClassAppender(BootstrapCssClass.LIST_GROUP_ITEM))
    }
}

inline fun <T> createListGroup(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
    crossinline createItemHandler: ListGroup<T>.(id: String, model: IModel<T>) -> Component
) = object : ListGroup<T>(id, model, *behaviors) {
    override fun createItem(id: String, model: IModel<T>) = createItemHandler(id, model)
}

inline fun <T> MarkupContainer.listGroup(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
    crossinline createItemHandler: ListGroup<T>.(id: String, model: IModel<T>) -> Component
) {
    add(createListGroup(id, model, behaviors = behaviors, createItemHandler))
}