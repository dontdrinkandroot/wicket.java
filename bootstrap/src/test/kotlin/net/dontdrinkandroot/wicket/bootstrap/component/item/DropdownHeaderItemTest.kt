package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DropdownHeaderItemTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component = DropdownHeaderItem("id", Model.of("Label"))
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" class=\"dropdown-header\">Label</wicket:container>",
            componentMarkup.toString()
        )
    }
}