package net.dontdrinkandroot.wicket.markup.repeater.data

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.repeater.Item
import org.apache.wicket.markup.repeater.data.DataView
import org.apache.wicket.markup.repeater.data.IDataProvider

inline fun <T> dataView(
    id: String,
    dataProvider: IDataProvider<T>,
    vararg behaviors: Behavior,
    crossinline populateItemHandler: Item<T>.(dataView: DataView<T>) -> Any?
) = object : DataView<T>(id, dataProvider) {
    init {
        behaviors.forEach { add(it) }
    }

    override fun populateItem(item: Item<T>) {
        populateItemHandler(item, this)
    }
}

inline fun <T> dataView(
    id: String,
    dataProvider: IDataProvider<T>,
    itemsPerPage: Long,
    vararg behaviors: Behavior,
    crossinline populateItemHandler: Item<T>.(dataView: DataView<T>) -> Any?
) = object : DataView<T>(id, dataProvider, itemsPerPage) {
    init {
        behaviors.forEach { add(it) }
    }

    override fun populateItem(item: Item<T>) {
        populateItemHandler(item, this)
    }
}