package net.dontdrinkandroot.wicket.markup.html.list

import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.list.ListView
import org.apache.wicket.model.IModel
import net.dontdrinkandroot.wicket.markup.html.list.ListView as DdrListView

class ListView<T>(
    id: String,
    model: IModel<List<T>>? = null,
    private val populateItemHandler: (context: DdrListView<T>, item: ListItem<T>) -> Any?
) : ListView<T>(id, model) {

    override fun populateItem(item: ListItem<T>) {
        populateItemHandler(this, item)
    }
}