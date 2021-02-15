package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BadgeBehaviorTest : AbstractWicketTest() {

    @Test
    fun testDefault() {
        val component = WebMarkupContainer("id")
        component.add(BadgeBehavior())
        val componentMarkup = ComponentRenderer.renderComponent(component)
        val tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "badge"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "badge-secondary"))
    }
}