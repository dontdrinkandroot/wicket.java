package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DropdownDividerItemTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component = DropdownDividerItem("id")
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" class=\"dropdown-divider\" role=\"separator\"></wicket:container>",
            componentMarkup.toString()
        )
    }
}