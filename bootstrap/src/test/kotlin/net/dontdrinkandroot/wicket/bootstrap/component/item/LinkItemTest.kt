package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LinkItemTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component: LinkItem<Void> = object : LinkItem<Void>("id", labelModel = Model("Label")) {
            override fun onClick() {
                /* Noop */
            }
        }
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id"><wicket:panel>
    <a href="./wicket/page?0-0.-id-link" wicket:id="link">Label</a>
    <wicket:child/>
</wicket:panel></wicket:container>""",
            componentMarkup.toString()
        )
    }
}