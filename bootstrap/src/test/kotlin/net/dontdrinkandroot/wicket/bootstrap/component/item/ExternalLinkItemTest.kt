package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ExternalLinkItemTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component = ExternalLinkItem("id", Model.of("Label"), Model.of("http://example.com"))
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id"><wicket:panel>
    <a href="http://example.com" wicket:id="link" rel="external">Label</a>
    <wicket:child/>
</wicket:panel></wicket:container>""", componentMarkup.toString()
        )
    }
}