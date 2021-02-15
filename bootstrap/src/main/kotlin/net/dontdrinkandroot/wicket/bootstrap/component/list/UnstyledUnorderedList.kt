package net.dontdrinkandroot.wicket.bootstrap.component.list

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.UnorderedList
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object.
 */
abstract class UnstyledUnorderedList<T>(id: String, model: IModel<List<T>>? = null) : UnorderedList<T>(id, model) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.LIST_UNSTYLED))
    }
}