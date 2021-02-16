package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class OutputMarkupPlaceholderTagBehaviorTest : AbstractWicketTest() {

    @Test
    fun testIsApplied() {
        val container = WebMarkupContainer("id")
        container.isVisible = false

        var componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertNull(componentMarkup)

        container.add(OutputMarkupPlaceholderTagBehavior())
        componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:container id="id1" hidden="" data-wicket-placeholder=""></wicket:container>""",
            componentMarkup.toString()
        )

        /* Test still valid on second rendering */
        componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:container id="id1" hidden="" data-wicket-placeholder=""></wicket:container>""",
            componentMarkup.toString()
        )
    }
}