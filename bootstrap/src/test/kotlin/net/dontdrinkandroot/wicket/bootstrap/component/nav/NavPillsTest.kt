package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NavPillsTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val component = RepeatingNavPills<Void>("id")
        val markup = ComponentRenderer.renderComponent(component).toString()
        val tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id")
        Assertions.assertEquals("nav nav-pills", tagTester.getAttribute("class"))
    }

    @Test
    fun testStackedMarkup() {
        val component: RepeatingNavPills<*> = RepeatingNavPills<Void>("id", stacked = true)
        val markup = ComponentRenderer.renderComponent(component).toString()
        val tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id")
        Assertions.assertEquals("nav nav-pills nav-stacked", tagTester.getAttribute("class"))
    }

    @Test
    fun testJustifiedMarkup() {
        val component: RepeatingNavPills<*> = RepeatingNavPills<Void>("id", justified = true)
        val markup = ComponentRenderer.renderComponent(component).toString()
        val tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id")
        Assertions.assertEquals("nav nav-pills nav-justified", tagTester.getAttribute("class"))
    }
}