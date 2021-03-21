package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.bootstrap.css.NavbarPosition
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarStyle
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NavbarTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val component = navbar("id") {}
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()

        var tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar-light"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar-expand-lg"))

        tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "container")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "container"))
    }

    @Test
    fun testPositioningAndStyle() {
        val component =
            navbar("id", position = Model(NavbarPosition.FIXED_TOP), style = Model(NavbarStyle.DARK)) {}
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()

        var tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar-dark"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "fixed-top"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar-expand-lg"))

        tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "container")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "container"))
    }
}