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
    labelModel: IModel<String?>,
    model: IModel<T>? = null
) : AbstractLabeledItem<T>(id, labelModel, model) {

    var prependIconModel: IModel<CssClass>? = null
        private set

    private var appendIconModel: IModel<CssClass>? = null

    private lateinit var link: L

    fun setPrependIcon(prependIcon: CssClass?): AbstractLinkItem<*, *> {
        if (prependIcon == null) {
            prependIconModel = null
        } else {
            prependIconModel = Model.of(prependIcon)
        }
        return this
    }

    fun setAppendIcon(appendIcon: CssClass?): AbstractLinkItem<*, *> {
        if (appendIcon == null) {
            appendIconModel = null
        } else {
            appendIconModel = Model.of(appendIcon)
        }
        return this
    }

    fun setAppendIconModel(): IModel<CssClass>? {
        return appendIconModel
    }

    override fun onInitialize() {
        super.onInitialize()
        link = createLink("link")
        link.body = this.label
        this.add(DisabledCssBehavior())
        link.add(object : IconBehavior() {
            public override fun getPrependIconModel(): IModel<CssClass> {
                return this@AbstractLinkItem.prependIconModel!!
            }

            public override fun getAppendIconModel(): IModel<CssClass> {
                return setAppendIconModel()!!
            }
        })
        this.add(link)

        /* Link is also active if item is active */
        link.add(CssClassAppender(CssClassToggleModel(BootstrapCssClass.ACTIVE, { active })))
        link.add(CssClassAppender {
            var parent = parent
            if (parent is ItemContainer) {
                (parent as ItemContainer).linkClass
            }
            parent = parent.parent
            if (parent is ItemContainer) {
                (parent as ItemContainer).linkClass
            }
            null
        })
    }

    fun getLink(): L {
        return link
    }

    protected abstract fun createLink(id: String?): L
}