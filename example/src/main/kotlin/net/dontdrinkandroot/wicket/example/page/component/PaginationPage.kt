package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.pagination.AjaxPaginationPanel
import net.dontdrinkandroot.wicket.bootstrap.component.pagination.PaginationPanel
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.request.mapper.parameter.PageParameters

class PaginationPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun onInitialize() {
        super.onInitialize()
        val pageable: IPageable = object : IPageable {
            private var currentPage: Long = 0
            override fun setCurrentPage(page: Long) {
                currentPage = page
            }

            override fun getPageCount() = 20L

            override fun getCurrentPage() = currentPage
        }
        val currentPageLabel = Label("currentPage") { pageable.currentPage.toString() }
        currentPageLabel.outputMarkupId = true
        this.add(currentPageLabel)
        val pagination = PaginationPanel("pagination", pageable)
        this.add(pagination)
        val ajaxPagination: AjaxPaginationPanel = object : AjaxPaginationPanel("ajaxPagination", pageable) {
            override fun onPageChanged(target: AjaxRequestTarget?) {
                super.onPageChanged(target)
                target?.add(currentPageLabel)
            }
        }
        this.add(ajaxPagination)
    }

    override fun createPageHeadingModel() = "Pagination".model()
}