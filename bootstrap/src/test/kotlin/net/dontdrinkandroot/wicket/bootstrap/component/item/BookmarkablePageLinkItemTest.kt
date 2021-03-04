package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.TestHomePage
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.core.util.string.ComponentRenderer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BookmarkablePageLinkItemTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component: BookmarkablePageLinkItem<*> =
            BookmarkablePageLinkItem<Any?>("id", labelModel = "Label".model(), pageClass = TestHomePage::class)
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id"><wicket:panel>
    <a href="./" wicket:id="link">Label</a>
    <wicket:child/>
</wicket:panel></wicket:container>""", componentMarkup.toString()
        )
    }
}