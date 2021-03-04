package net.dontdrinkandroot.wicket.component.basic

import net.dontdrinkandroot.wicket.model.ListItemModel
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.util.string.Strings

abstract class AbstractList<T>(
    id: String,
    model: IModel<List<T>>? = null,
    vararg behaviors: Behavior,
) : GenericPanel<List<T>>(id, model) {

    init {
        add(*behaviors)
    }

    private lateinit var itemView: RepeatingView

    override fun onInitialize() {
        super.onInitialize()
        itemView = object : RepeatingView("item") {
            override fun onPopulate() {
                this.removeAll()
                if (model != null && model.getObject() != null) {
                    for (idx in model.getObject().indices) {
                        val itemModel: IModel<T> = ListItemModel(model, idx)
                        val listComponent = createItem(newChildId(), itemModel)
                        processListComponent(listComponent)
                        this.add(listComponent)
                    }
                }
            }
        }
        this.add(itemView)
    }

    override fun onComponentTag(tag: ComponentTag) {
        super.onComponentTag(tag)
        this.checkComponentTag(tag, "ul", "ol")
    }

    protected fun checkComponentTag(tag: ComponentTag, vararg names: String) {
        for (name in names) {
            if (tag.name == name) {
                return
            }
        }
        val joinedNames = Strings.join(",", *names)
        val msg = String.format(
            "Component [%s] (path = [%s]) must be applied to a tag of type [%s], not: %s",
            id,
            this.path,
            joinedNames,
            tag.toUserDebugString()
        )
        findMarkupStream().throwMarkupException(msg)
    }

    protected open fun processListComponent(listComponent: Component) {
        /* Override to apply styles to list component */
    }

    protected abstract fun createItem(id: String, model: IModel<T>): Component
}