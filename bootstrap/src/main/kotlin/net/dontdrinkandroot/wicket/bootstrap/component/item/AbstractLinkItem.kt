package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @param <T> Type of the model object.
 * @param <L> Type of the [AbstractLink].
 */
abstract class AbstractLinkItem<T, L : AbstractLink> constructor(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    val prependIconModel: IModel<CssClass> = Model(null),
    val appendIconModel: IModel<CssClass> = Model(null)
) : AbstractLabeledItem<T>(id, model, labelModel) {

    lateinit var link: L
        protected set

    override fun onInitialize() {
        super.onInitialize()

        link = createLink("link")
        link.body = this.label
        this.add(DisabledCssBehavior())
        link.add(IconBehavior(prependIconModel, appendIconModel))
        this.add(link)

        /* Link is also active if item is active */
        link.add(CssClassAppender(CssClassToggleModel(BootstrapCssClass.ACTIVE, { active })))

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