package net.dontdrinkandroot.wicket.bootstrap.component.pagination

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.PaginationSize
import org.apache.wicket.Component
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

open class PaginationPanel constructor(
    id: String,
    val pageable: IPageable,
    size: PaginationSize? = null
) : Panel(id) {

    private lateinit var pageItemView: RepeatingView

    var viewSize = 5

    init {
        size?.let { add(CssClassAppender(it)) }
    }

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.PAGINATION))

        val firstItem: Component = createFirstPageItem("firstItem")
        this.add(firstItem)

        val prevItem: Component = createPrevPageItem("prevItem")
        this.add(prevItem)

        val nextItem: Component = createNextPageItem("nextItem")
        this.add(nextItem)

        val lastItem: Component = createLastPageItem("lastItem")
        this.add(lastItem)

        pageItemView = RepeatingView("pageItem")
        this.add(pageItemView)
    }

    override fun onBeforeRender() {
        super.onBeforeRender()
        pageItemView.removeAll()
        val curPage = pageable.currentPage
        val pageCount = pageable.pageCount
        var desiredStart = curPage - viewSize / 2
        var desiredEnd = curPage + viewSize / 2
        if (desiredStart < 0) {
            val offset = 0 - desiredStart
            desiredStart = desiredStart + offset
            desiredEnd = desiredEnd + offset
        }
        if (desiredEnd > pageCount - 1) {
            val offset = desiredEnd - (pageCount - 1)
            desiredStart = desiredStart - offset
            desiredEnd = desiredEnd - offset
        }
        val displayStart = Math.max(0, desiredStart)
        val displayEnd = Math.min(pageCount - 1, desiredEnd)
        for (page in displayStart..displayEnd) {
            pageItemView.add(createPageItem(pageItemView.newChildId(), page))
        }
    }

    protected fun createFirstPageItem(id: String): AbstractPageLinkItem {
        return object : FirstPageLinkItem(id, pageable) {
            override fun createLink(id: String, paginablePageModel: IModel<Long>): AbstractLink {
                return this@PaginationPanel.createLink(id, paginablePageModel)
            }
        }
    }

    protected fun createPrevPageItem(id: String): AbstractPageLinkItem {
        return object : PrevPageLinkItem(id, pageable) {
            override fun createLink(id: String, paginablePageModel: IModel<Long>): AbstractLink {
                return this@PaginationPanel.createLink(id, paginablePageModel)
            }
        }
    }

    protected fun createNextPageItem(id: String): AbstractPageLinkItem {
        return object : NextPageLinkItem(id, pageable) {
            override fun createLink(id: String, paginablePageModel: IModel<Long>): AbstractLink {
                return this@PaginationPanel.createLink(id, paginablePageModel)
            }
        }
    }

    protected fun createLastPageItem(id: String): AbstractPageLinkItem {
        return object : LastPageLinkItem(id, pageable) {
            override fun createLink(id: String, paginablePageModel: IModel<Long>): AbstractLink {
                return this@PaginationPanel.createLink(id, paginablePageModel)
            }
        }
    }

    protected fun createPageItem(id: String, page: Long): AbstractPageLinkItem {
        return object : PageLinkItem(id, pageable, page) {
            override fun createLink(id: String, paginablePageModel: IModel<Long>): AbstractLink {
                return this@PaginationPanel.createLink(id, paginablePageModel)
            }
        }
    }

    protected open fun createLink(id: String, paginablePageModel: IModel<Long>): AbstractLink {
        val link: Link<Long> = object : Link<Long>(id, paginablePageModel) {
            override fun onClick() {
                pageable.currentPage = this.modelObject!!
            }
        }
        link.add(CssClassAppender(BootstrapCssClass.PAGE_LINK))
        return link
    }
}