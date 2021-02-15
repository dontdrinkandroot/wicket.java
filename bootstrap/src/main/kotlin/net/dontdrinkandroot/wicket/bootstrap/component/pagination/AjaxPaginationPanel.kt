package net.dontdrinkandroot.wicket.bootstrap.component.pagination

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.PaginationSize
import org.apache.wicket.Component
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.model.IModel

open class AjaxPaginationPanel(id: String, pageable: IPageable, size: PaginationSize? = null) :
    PaginationPanel(id, pageable, size) {

    init {
        this.outputMarkupId = true
    }

    override fun createLink(id: String, paginablePageModel: IModel<Long>): AbstractLink {
        val link: AjaxLink<Long> = object : AjaxLink<Long>(id, paginablePageModel) {
            override fun onClick(target: AjaxRequestTarget) {
                pageable.currentPage = this.model.getObject()
                onPageChanged(target)
            }
        }
        link.add(CssClassAppender(BootstrapCssClass.PAGE_LINK))
        return link
    }

    protected open fun onPageChanged(target: AjaxRequestTarget?) {
        if (pageable is Component) {
            target?.add(pageable as Component)
        }
        target?.add(this)
    }
}