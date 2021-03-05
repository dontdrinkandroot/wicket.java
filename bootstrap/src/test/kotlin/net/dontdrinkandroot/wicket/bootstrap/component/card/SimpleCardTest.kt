package net.dontdrinkandroot.wicket.bootstrap.component.card

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SimpleCardTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val component = SimpleCard<String>("id", headingModel = Model("title"))
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        val componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        Assertions.assertTrue(componentTester.getAttributeIs("class", "card"))
        val headingTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "header")
        Assertions.assertTrue(headingTester.getAttributeIs("class", "card-header"))
    }
}