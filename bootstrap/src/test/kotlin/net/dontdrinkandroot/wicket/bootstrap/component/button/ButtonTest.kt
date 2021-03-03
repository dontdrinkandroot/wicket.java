package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ButtonTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component = button<Void>("id", bodyModel = Model("Label")) {}
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" class=\"btn btn-secondary\">Label</wicket:container>",
            componentMarkup
        )
    }
}