package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class EnabledBehaviorTest : AbstractWicketTest() {

    @Test
    fun testModelSwitching() {
        val container = object : WebMarkupContainer("id") {
            override fun onComponentTag(tag: ComponentTag) {
                super.onComponentTag(tag)
                if (!this.isEnabledInHierarchy) tag.attributes["disabled"] = "disabled"
            }
        }
        val enabledModel = Model(false)
        container.add(EnabledBehavior(enabledModel))

        var componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id" disabled="disabled"></wicket:container>""",
            componentMarkup.toString()
        )

        enabledModel.setObject(true)
        componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id"></wicket:container>""",
            componentMarkup.toString()
        )
    }
}