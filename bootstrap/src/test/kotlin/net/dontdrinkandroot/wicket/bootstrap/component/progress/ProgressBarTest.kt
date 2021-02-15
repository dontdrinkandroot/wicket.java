package net.dontdrinkandroot.wicket.bootstrap.component.progress

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProgressBarTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val component = ProgressBar("id", Model.of(33))
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        val componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        Assertions.assertTrue(componentTester.getAttributeContains("class", "progress"))
        val barTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "bar")
        Assertions.assertEquals("progress-bar", barTester.getAttribute("class"))
        Assertions.assertEquals("progressbar", barTester.getAttribute("role"))
        Assertions.assertEquals("0", barTester.getAttribute("aria-valuemin"))
        Assertions.assertEquals("100", barTester.getAttribute("aria-valuemax"))
        Assertions.assertEquals("33", barTester.getAttribute("aria-valuenow"))
        Assertions.assertEquals("width: 33%;", barTester.getAttribute("style"))
        Assertions.assertTrue(barTester.hasAttribute("id"))
    }

    @Test
    fun testStripedAnimatedMarkup() {
        val component = ProgressBar("id", Model.of(33))
        Assertions.assertFalse(component.isStriped)
        component.setStriped(true)
        Assertions.assertTrue(component.isStriped)
        Assertions.assertFalse(component.isAnimated)
        component.setAnimated(true)
        Assertions.assertTrue(component.isAnimated)
        Assertions.assertTrue(component.isAnimated)
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        val componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        Assertions.assertTrue(componentTester.getAttributeContains("class", "progress"))
        val barTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "bar")
        Assertions.assertTrue(barTester.getAttributeContains("class", "progress-bar"))
        Assertions.assertTrue(barTester.getAttributeContains("class", "progress-bar-animated"))
        Assertions.assertTrue(barTester.getAttributeContains("class", "progress-bar-striped"))
        Assertions.assertEquals("progressbar", barTester.getAttribute("role"))
        Assertions.assertEquals("0", barTester.getAttribute("aria-valuemin"))
        Assertions.assertEquals("100", barTester.getAttribute("aria-valuemax"))
        Assertions.assertEquals("33", barTester.getAttribute("aria-valuenow"))
        Assertions.assertEquals("width: 33%;", barTester.getAttribute("style"))
        Assertions.assertTrue(barTester.hasAttribute("id"))
    }
}