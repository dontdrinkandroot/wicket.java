package net.dontdrinkandroot.wicket.component.basic

import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

abstract class RepeatingList<T>(id: String?, model: IModel<T>? = null) : GenericPanel<T>(id, model) {

    override fun onInitialize() {
        super.onInitialize()
        val itemView = RepeatingView("item")
        populateItems(itemView)
        this.add(itemView)
    }

    override fun onComponentTag(tag: ComponentTag) {
        super.onComponentTag(tag)
        if ("ul" != tag.name && "ol" != tag.name) {
            findMarkupStream().throwMarkupException("Must be applied to ul or ol tag")
        }
    }

    protected abstract fun populateItems(itemView: RepeatingView)
}