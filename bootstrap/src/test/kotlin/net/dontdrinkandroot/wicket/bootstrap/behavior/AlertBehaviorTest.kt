package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AlertBehaviorTest : AbstractWicketTest() {

    @Test
    fun testInfo() {
        val container = WebMarkupContainer("id")
        container.add(AlertBehavior(AlertStyle.INFO))
        val componentMarkup = ComponentRenderer.renderComponent(container)
        val tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "alert"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "alert-info"))
    }
}