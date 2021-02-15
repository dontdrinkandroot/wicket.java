package net.dontdrinkandroot.wicket.bootstrap.component.pagination

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.IModel

abstract class AbstractPageLinkItem(id: String, val pageable: IPageable) : Panel(id) {

    val link: AbstractLink

    init {
        link = createLink("link", paginablePageModel)
        onLinkCreated(link)
        this.add(link)
        this.add(DisabledCssBehavior())
        this.add(CssClassAppender(BootstrapCssClass.PAGE_ITEM))
    }

    protected open fun onLinkCreated(link: AbstractLink) {
        this.link.body = createLabel()
        link.add(DisabledCssBehavior())
    }

    protected abstract val paginablePageModel: IModel<Long>

    protected abstract fun setPaginablePage()

    protected abstract fun createLabel(): IModel<String>

    protected abstract fun createLink(id: String, paginablePageModel: IModel<Long>): AbstractLink
}