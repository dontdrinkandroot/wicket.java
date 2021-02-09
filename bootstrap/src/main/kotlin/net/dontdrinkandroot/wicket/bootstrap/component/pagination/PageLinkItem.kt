package net.dontdrinkandroot.wicket.bootstrap.component.pagination

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.model.IModel

abstract class PageLinkItem(id: String, pageable: IPageable, private val page: Long) :
    AbstractPageLinkItem(id, pageable) {

    init {
        this.add(CssClassAppender(CssClassToggleModel(BootstrapCssClass.ACTIVE, { isCurrentPage })))
    }

    override fun createLabel(): IModel<String> {
        return IModel { (page + 1).toString() }
    }

    override fun setPaginablePage() {
        pageable.currentPage = page.coerceIn(0, pageable.pageCount - 1)
    }

    protected val isCurrentPage: Boolean
        protected get() = page == pageable.currentPage

    override fun getPaginablePageModel(): IModel<Long> {
        return IModel { page }
    }
}