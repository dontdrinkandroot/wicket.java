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
abstract class AbstractLinkItem<T, L : AbstractLink> @JvmOverloads constructor(
    id: String,
    model: IModel<T>? = null,
    labelModel: IModel<String>,
    val prependIconModel: IModel<CssClass> = Model(null),
    val appendIconModel: IModel<CssClass> = Model(null)
) : AbstractLabeledItem<T>(id, model, labelModel) {

    private lateinit var link: L

    fun setPrependIcon(prependIcon: CssClass?): AbstractLinkItem<*, *> {
        prependIconModel.setObject(prependIcon)
        return this
    }

    fun setAppendIcon(appendIcon: CssClass?): AbstractLinkItem<*, *> {
        appendIconModel.setObject(appendIcon)
        return this
    }

    override fun onInitialize() {
        super.onInitialize()
        link = createLink("link")
        link.body = this.label
        this.add(DisabledCssBehavior())
        link.add(IconBehavior(prependIconModel, appendIconModel))
        this.add(link)

        /* Link is also active if item is active */
        link.add(CssClassAppender(CssClassToggleModel(BootstrapCssClass.ACTIVE, { active })))
        link.add(CssClassAppender(IModel<CssClass> {
            var parent = parent
            if (parent is ItemContainer) {
                (parent as ItemContainer).linkClass
            }
            parent = parent.parent
            if (parent is ItemContainer) {
                (parent as ItemContainer).linkClass
            }
            null
        }))
    }

    fun getLink(): L {
        return link
    }

    protected abstract fun createLink(id: String): L
}