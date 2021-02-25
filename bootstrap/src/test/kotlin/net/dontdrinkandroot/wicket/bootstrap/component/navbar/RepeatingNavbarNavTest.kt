package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.page.SignInPage
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RepeatingNavbarNavTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component = RepeatingNavbarNav<Void>("id", populateItemsHandler = { itemView ->
            itemView.add(
                BookmarkablePageLinkItem<Void>(
                    itemView.newChildId(),
                    labelModel = "Item".model(),
                    pageClass = SignInPage::class.java
                )
            )
        })
        val markup = ComponentRenderer.renderComponent(component).toString()

        val navbarTester = TagTester.createTagByAttribute(markup, "wicket:id", "id")
        Assertions.assertEquals("navbar-nav", navbarTester.getAttribute("class"))

        val itemTester = TagTester.createTagByAttribute(markup, "wicket:id", "item")
        Assertions.assertEquals("nav-item", itemTester.getAttribute("class"))

        val linkTester = TagTester.createTagByAttribute(markup, "wicket:id", "link")
        Assertions.assertEquals("nav-link", linkTester.getAttribute("class"))
    }
}