package net.dontdrinkandroot.wicket.bootstrap.component.list

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.UnorderedList
import org.apache.wicket.Component
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object.
 */
abstract class ListGroup<T>(id: String, model: IModel<List<T>>? = null) : UnorderedList<T>(id, model) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.LIST_GROUP))
    }

    override fun processListComponent(listComponent: Component) {
        super.processListComponent(listComponent)
        listComponent.add(CssClassAppender(BootstrapCssClass.LIST_GROUP_ITEM))
    }
}