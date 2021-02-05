package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ForComponentIdBehaviorTest : AbstractWicketTest() {

    @Test
    fun testDefaultBehavior() {
        val component1 = WebMarkupContainer("id")
        component1.markupId = "testid"
        val component2 = WebMarkupContainer("id")
        component2.add(ForComponentIdBehavior(component1))
        val componentMarkup = ComponentRenderer.renderComponent(component2)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" for=\"testid\"></wicket:container>",
            componentMarkup.toString()
        )
    }
}