package net.dontdrinkandroot.wicket.bootstrap.component.panel

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlainPanelTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val component: PlainPanel<*> = PlainPanel<Any?>("id", null)
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        val componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        Assertions.assertTrue(componentTester.getAttributeIs("class", "panel panel-default"))
    }
}