package net.dontdrinkandroot.wicket.bootstrap.component.list

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.AbstractList
import net.dontdrinkandroot.wicket.component.basic.OrderedList
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object.
 */
open class InlineOrderedList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    behaviors: Collection<Behavior> = emptyList(),
    createItemComponentHandler: AbstractList<T>.(id: String, model: IModel<T>) -> Component
) : OrderedList<T>(id, model, behaviors, createItemComponentHandler) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.LIST_INLINE))
    }
}