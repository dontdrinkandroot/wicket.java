package net.dontdrinkandroot.wicket.bootstrap.component.pagination

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.PaginationSize
import net.dontdrinkandroot.wicket.markup.html.link.AjaxBookmarkablePageLink
import org.apache.wicket.Page
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.model.IModel
import org.apache.wicket.request.mapper.parameter.PageParameters

class AjaxBookmarkablePaginationPanel(id: String, pageable: IPageable, size: PaginationSize? = null) :
    AjaxPaginationPanel(id, pageable, size) {

    init {
        this.outputMarkupId = true
    }

    override fun createLink(id: String, paginablePageModel: IModel<Long>): AbstractLink {
        val link: AjaxBookmarkablePageLink<Long> = object : AjaxBookmarkablePageLink<Long>(id, Page::class.java) {
            public override fun onClick(target: AjaxRequestTarget?) {
                pageable.currentPage = paginablePageModel.getObject()
                onPageChanged(target)
            }

            override fun getPageParameters(): PageParameters {
                val parameters = PageParameters(this.page.pageParameters)
                /* Zero based page index */parameters["page"] = paginablePageModel.getObject() + 1
                return parameters
            }

            override fun getURL(): CharSequence {
                val parameters = this.pageParameters
                return this.urlFor(this.page.javaClass, parameters)
            }
        }
        link.add(CssClassAppender(BootstrapCssClass.PAGE_LINK))
        return link
    }
}