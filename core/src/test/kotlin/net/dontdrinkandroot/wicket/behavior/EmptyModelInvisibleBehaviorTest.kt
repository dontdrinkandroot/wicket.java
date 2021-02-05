package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.Serializable

class EmptyModelInvisibleBehaviorTest : AbstractWicketTest() {

    @Test
    fun testNoModelSet() {
        val container = WebMarkupContainer("id")
        container.add(EmptyModelInvisibleBehavior())
        Assertions.assertNull(ComponentRenderer.renderComponent(container))
    }

    @Test
    fun testModelNull() {
        val container = WebMarkupContainer("id")
        container.add(EmptyModelInvisibleBehavior())
        container.defaultModel = Model<Serializable?>(null)
        Assertions.assertNull(ComponentRenderer.renderComponent(container))
    }

    @Test
    fun testModelEmptyString() {
        val container = WebMarkupContainer("id")
        container.add(EmptyModelInvisibleBehavior())
        container.defaultModel = Model("")
        Assertions.assertNull(ComponentRenderer.renderComponent(container))
    }

    @Test
    fun testModelExisting() {
        val container = WebMarkupContainer("id")
        container.add(EmptyModelInvisibleBehavior())
        container.defaultModel = Model("Test")
        Assertions.assertEquals(
            """<wicket:container wicket:id="id"></wicket:container>""",
            ComponentRenderer.renderComponent(container).toString()
        )
    }
}