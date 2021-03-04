package net.dontdrinkandroot.wicket.markup.repeater.data

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.markup.repeater.Item
import org.apache.wicket.markup.repeater.data.DataView
import org.apache.wicket.markup.repeater.data.IDataProvider
import org.apache.wicket.model.IModel

abstract class RepeatingDataView<T>(id: String, dataProvider: IDataProvider<T>, itemsPerPage: Long) : Panel(id),
    IPageable {

    private var dataView: DataView<T>

    init {
        this.dataView = object : DataView<T>("items", dataProvider, itemsPerPage) {
            override fun populateItem(item: Item<T>) {
                item.add(this@RepeatingDataView.createChild("child", item.model))
            }
        }
        this.add(dataView)
    }

    override fun getCurrentPage() = dataView.currentPage

    override fun setCurrentPage(page: Long) {
        dataView.currentPage = page
    }

    override fun getPageCount() = dataView.pageCount

    abstract fun createChild(id: String, model: IModel<T>): Component
}

inline fun <T> repeatingDataView(
    id: String,
    dataProvider: IDataProvider<T>,
    itemsPerPage: Long,
    vararg behaviors: Behavior,
    crossinline createChildHandler: RepeatingDataView<T>.(id: String, model: IModel<T>) -> Component
) = object : RepeatingDataView<T>(id, dataProvider, itemsPerPage) {
    init {
        add(*behaviors)
    }

    override fun createChild(id: String, model: IModel<T>) = createChildHandler(id, model)
}