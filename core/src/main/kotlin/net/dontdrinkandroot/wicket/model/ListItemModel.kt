package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

class ListItemModel<T>(private val listModel: IModel<List<T>>, private val idx: Int) : IModel<T> {

    override fun getObject(): T = listModel.getObject()[idx]

    override fun setObject(`object`: T) {
        val list = listModel.getObject()
        if (list !is MutableList<T>) throw RuntimeException("List is not mutable")
        list[idx] = `object`
    }
}