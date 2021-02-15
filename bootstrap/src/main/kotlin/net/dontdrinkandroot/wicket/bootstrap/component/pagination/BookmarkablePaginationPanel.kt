package net.dontdrinkandroot.wicket.bootstrap.component.pagination

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.PaginationSize
import org.apache.wicket.Page
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.model.IModel
import org.apache.wicket.request.mapper.parameter.PageParameters

class BookmarkablePaginationPanel(id: String, pageable: IPageable, size: PaginationSize? = null) :
    PaginationPanel(id, pageable, size) {

    override fun createLink(id: String, paginablePageModel: IModel<Long>): AbstractLink {
        val link: BookmarkablePageLink<Long> = object : BookmarkablePageLink<Long>(id, Page::class.java) {
            override fun getPageParameters(): PageParameters {
                val parameters = PageParameters(this.page.pageParameters)
                /* Zero based page index */
                parameters["page"] = paginablePageModel.getObject() + 1
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