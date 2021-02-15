package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DisablingSubmitButtonTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component = DisablingSubmitButton("id")
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" id=\"id1\" class=\"btn btn-primary\"></wicket:container>",
            componentMarkup.toString()
        )
    }
}