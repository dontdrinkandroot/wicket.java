package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.disabledCss
import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 * @param <L> Type of the [AbstractLink].
 */
abstract class AbstractLinkItem<T, L : AbstractLink>(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    val prependIconModel: IModel<CssClass> = Model(null),
    val appendIconModel: IModel<CssClass> = Model(null),
    val behaviors: Array<out Behavior> = emptyArray(),
    private vararg val linkBehaviors: Behavior,
) : AbstractLabeledItem<T>(id, model, labelModel, *behaviors) {

    lateinit var link: L
        protected set

    override fun onInitialize() {
        super.onInitialize()

        link = createLink("link")
        link.body = this.label
        this.add(disabledCss())
        link.add(IconBehavior(prependIconModel, appendIconModel))
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