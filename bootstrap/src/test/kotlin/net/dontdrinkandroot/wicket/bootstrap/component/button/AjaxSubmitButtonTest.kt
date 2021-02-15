package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AjaxSubmitButtonTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component = AjaxSubmitButton("id", labelModel = Model.of("Label"))
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" id=\"id1\" class=\"btn btn-primary\">Label</wicket:container>",
            componentMarkup
        )
    }
}