package net.dontdrinkandroot.wicket.bootstrap.component.pagination

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PaginationPanelTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val pageable: IPageable = object : IPageable {
            private var page: Long = 0
            private val pageCount: Long = 20
            override fun setCurrentPage(page: Long) {
                this.page = page
            }

            override fun getPageCount(): Long {
                return pageCount
            }

            override fun getCurrentPage(): Long {
                return page
            }
        }
        val component = PaginationPanel("id", pageable)
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        val componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        Assertions.assertTrue(componentTester.getAttributeContains("class", "pagination"))
        val firstItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "firstItem")
        Assertions.assertTrue(firstItemTester.getAttributeContains("class", "disabled"))
        val prevItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "prevItem")
        Assertions.assertTrue(prevItemTester.getAttributeContains("class", "disabled"))
        val pageTesters = TagTester.createTagsByAttribute(componentMarkup, "wicket:id", "pageItem", false)
        Assertions.assertEquals(component.viewSize, pageTesters.size)
        val currentPageTester = pageTesters[0]
        Assertions.assertTrue(currentPageTester.getAttributeContains("class", "active"))
        val nextItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "nextItem")
        val lastItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "lastItem")
    }
}