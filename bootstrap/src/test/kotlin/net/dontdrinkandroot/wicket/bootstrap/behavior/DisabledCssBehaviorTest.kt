package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DisabledCssBehaviorTest : AbstractWicketTest() {

    @Test
    fun testEnabledMarkup() {
        val component = WebMarkupContainer("id")
        component.add(DisabledCssBehavior())
        val componentMarkup = ComponentRenderer.renderComponent(component)
        val tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertFalse(tagTester.getAttributeContains("class", "disabled"))
    }

    @Test
    fun testDisabledMarkup() {
        val component = WebMarkupContainer("id")
        component.add(DisabledCssBehavior())
        component.isEnabled = false
        val componentMarkup = ComponentRenderer.renderComponent(component)
        val tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "disabled"))
    }
}