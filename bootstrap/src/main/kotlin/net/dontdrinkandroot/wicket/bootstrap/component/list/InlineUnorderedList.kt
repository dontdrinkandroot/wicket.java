package net.dontdrinkandroot.wicket.bootstrap.component.list

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.UnorderedList
import org.apache.wicket.Component
import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

abstract class InlineUnorderedList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
) : UnorderedList<T>(id, model, *behaviors) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.LIST_INLINE))
    }

    override fun processListComponent(listComponent: Component) {
        listComponent.add(CssClassAppender(BootstrapCssClass.LIST_INLINE_ITEM))
    }
}

inline fun <T> inlineUnorderedList(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
    crossinline createItemHandler: InlineUnorderedList<T>.(id: String, model: IModel<T>) -> Component
) = object : InlineUnorderedList<T>(id, model, *behaviors) {
    override fun createItem(id: String, model: IModel<T>) = createItemHandler(id, model)
}

inline fun <T> MarkupContainer.addInlineUnorderedList(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
    crossinline createItemHandler: InlineUnorderedList<T>.(id: String, model: IModel<T>) -> Component
) {
    add(inlineUnorderedList(id, model, behaviors = behaviors, createItemHandler))
}