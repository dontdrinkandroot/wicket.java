package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.disabledCss
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the model object.
 * @param <L> Type of the [AbstractLink].
 */
abstract class AbstractLinkItem<T, L : AbstractLink>(
    id: String,
    model: IModel<T>? = null,
    label: IModel<String>,
    val behaviors: Array<out Behavior> = emptyArray(),
    private vararg val linkBehaviors: Behavior,
) : AbstractLabeledItem<T>(id, model, label, *behaviors) {

    lateinit var link: L
        protected set

    override fun onInitialize() {
        super.onInitialize()

        link = createLink("link")
        link.body = this.label
        this.add(disabledCss())
        link.add(*linkBehaviors)
        this.add(link)

        /* If direct parent or parent of parent is item append the link class */
        link.add(CssClassAppender {
            var parent = parent
            if (parent is ItemContainer) return@CssClassAppender (parent as ItemContainer).linkClass
            parent = parent.parent
            if (parent is ItemContainer) return@CssClassAppender (parent as ItemContainer).linkClass
            return@CssClassAppender null
        })
    }

    protected abstract fun createLink(id: String): L
}