package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.css.StringCssClass
import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CompositeBehaviorTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component = WebMarkupContainer("id")
        val behavior = CompositeBehavior()
        behavior.addBehavior(CssClassAppender(StringCssClass("cssclass")))
        behavior.addBehavior(TitleModifier("Title"))
        component.add(behavior)
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" class=\"cssclass\" title=\"Title\"></wicket:container>",
            componentMarkup.toString()
        )
    }
}