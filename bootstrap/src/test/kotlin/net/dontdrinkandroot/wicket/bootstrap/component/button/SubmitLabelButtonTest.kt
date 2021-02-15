package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SubmitLabelButtonTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val component = SubmitLabelButton("id")
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        val componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        Assertions.assertTrue(componentTester.getAttributeIs("type", "submit"))
        Assertions.assertTrue(componentTester.getAttributeIs("class", "btn btn-primary"))
        Assertions.assertEquals("button", componentTester.name)
    }
}