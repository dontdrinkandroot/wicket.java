package net.dontdrinkandroot.wicket.bootstrap.panel

import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SimplePanelTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val component = SimplePanel<String>("id", headingModel = "title".model())
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        val componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        Assertions.assertTrue(componentTester.getAttributeIs("class", "panel panel-default"))
        val headingTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "heading")
        Assertions.assertTrue(headingTester.getAttributeIs("class", "panel-heading"))
        val titleTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "title")
        Assertions.assertTrue(titleTester.getAttributeIs("class", "panel-title"))
    }
}