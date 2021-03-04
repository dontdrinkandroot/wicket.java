package net.dontdrinkandroot.wicket.bootstrap.component.list

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.OrderedList
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

abstract class InlineOrderedList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
) : OrderedList<T>(id, model, *behaviors) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.LIST_INLINE))
    }
}

inline fun <T> inlineOrderedList(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
    crossinline createItemHandler: InlineOrderedList<T>.(id: String, model: IModel<T>) -> Component
) = object : InlineOrderedList<T>(id, model, *behaviors) {
    override fun createItem(id: String, model: IModel<T>) = createItemHandler(id, model)
}