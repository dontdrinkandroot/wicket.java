package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TagNameModifierTest : AbstractWicketTest() {

    @Test
    fun testModelConstructor() {
        val container = WebMarkupContainer("id")
        container.add(TagNameModifier("div"))
        val componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:div wicket:id="id"></wicket:div>""",
            componentMarkup.toString()
        )
    }
}