package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

/**
 * A readonly List Model that contains all Integers between the given min and max value, min and max
 * included.
 */
class IntegerRangeListModel(min: Int, max: Int) : IModel<List<Int>> {

    private lateinit var list: MutableList<Int>

    var min: Int = min
        set(value) {
            field = value
            updateList()
        }

    var max: Int = max
        set(value) {
            field = value
            updateList()
        }

    init {
        this.min = min
        this.max = max
        updateList()
    }

    private fun updateList() {
        list = mutableListOf()
        for (i in min..max) {
            list.add(i)
        }
    }

    override fun getObject(): List<Int> = list
}