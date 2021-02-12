package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.css.StringCssClass
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class IconBehaviorTest : AbstractWicketTest() {

    @Test
    fun testEmptyIconBehavior() {
        val component = WebMarkupContainer("id")
        component.add(IconBehavior())
        val componentMarkup = ComponentRenderer.renderComponent(component)
        val componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertNotNull(componentTagTester)
        Assertions.assertEquals("", componentTagTester.value)
    }

    @Test
    fun testIconOnly() {
        val component = WebMarkupContainer("id")
        component.add(IconBehavior(StringCssClass("prependIconClass")))
        val componentMarkup = ComponentRenderer.renderComponent(component)
        val componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertNotNull(componentTagTester)
        Assertions.assertEquals("<span class=\"prependIconClass\"></span>", componentTagTester.value)
    }

    @Test
    fun testPrependIcon() {
        val component = Label("id", Model.of("body"))
        val iconBehavior: IconBehavior = IconBehavior(StringCssClass("prependIconClass"))
        component.add(iconBehavior)
        val componentMarkup = ComponentRenderer.renderComponent(component)
        val componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertNotNull(componentTagTester)
        Assertions.assertEquals(
            "<span class=\"prependIconClass\"></span>&nbsp;&nbsp;body",
            componentTagTester.value
        )
    }

    @Test
    fun testAppendIcon() {
        val component = Label("id", Model.of("body"))
        val iconBehavior: IconBehavior = IconBehavior(appendIcon = StringCssClass("appendIconClass"))
        component.add(iconBehavior)
        val componentMarkup = ComponentRenderer.renderComponent(component)
        val componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertNotNull(componentTagTester)
        Assertions.assertEquals(
            "body&nbsp;&nbsp;<span class=\"appendIconClass\"></span>",
            componentTagTester.value
        )
    }
}