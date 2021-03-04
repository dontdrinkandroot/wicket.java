package net.dontdrinkandroot.wicket.bootstrap.component.list

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.UnorderedList
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

abstract class UnstyledUnorderedList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
) : UnorderedList<T>(id, model, *behaviors) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.LIST_UNSTYLED))
    }
}

inline fun <T> unstyledUnorderedList(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
    crossinline createItemHandler: UnstyledUnorderedList<T>.(id: String, model: IModel<T>) -> Component
) = object : UnstyledUnorderedList<T>(id, model, *behaviors) {
    override fun createItem(id: String, model: IModel<T>) = createItemHandler(id, model)
}