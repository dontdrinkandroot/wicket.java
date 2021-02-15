package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ButtonBehaviorTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val buttonContainer = WebMarkupContainer("id")
        buttonContainer.add(ButtonBehavior())
        val componentMarkup = ComponentRenderer.renderComponent(buttonContainer)
        val tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "btn"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "btn-secondary"))
        Assertions.assertFalse(tagTester.getAttributeContains("class", "disabled"))
    }

    @Test
    fun testDisabledMarkup() {
        val buttonContainer = WebMarkupContainer("id")
        buttonContainer.isEnabled = false
        buttonContainer.add(ButtonBehavior())
        val componentMarkup = ComponentRenderer.renderComponent(buttonContainer)
        val tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "btn"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "btn-secondary"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "disabled"))
    }
}