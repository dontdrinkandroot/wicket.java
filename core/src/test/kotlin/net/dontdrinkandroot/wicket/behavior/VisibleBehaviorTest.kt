package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class VisibleBehaviorTest : AbstractWicketTest() {

    @Test
    fun testModelSwitching() {
        val container = WebMarkupContainer("id")
        val visibleModel = Model(false)
        container.add(VisibleBehavior(visibleModel))

        var componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertNull(componentMarkup)

        visibleModel.setObject(true)
        componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id"></wicket:container>""",
            componentMarkup.toString()
        )
    }
}