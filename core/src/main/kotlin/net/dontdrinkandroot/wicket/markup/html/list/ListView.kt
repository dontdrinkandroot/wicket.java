package net.dontdrinkandroot.wicket.markup.html.list

import org.apache.wicket.MarkupContainer
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.list.ListView
import org.apache.wicket.model.IModel

inline fun <T> listView(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
    crossinline populateItemHandler: ListItem<T>.() -> Any?
) = object : ListView<T>(id, model) {
    init {
        add(*behaviors)
    }

    override fun populateItem(item: ListItem<T>) {
        populateItemHandler(item)
    }
}

inline fun <T> MarkupContainer.addListView(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
    crossinline populateItemHandler: ListItem<T>.() -> Any?
) {
    add(listView(id, model, behaviors = behaviors, populateItemHandler))
}