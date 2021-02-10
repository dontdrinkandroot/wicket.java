package net.dontdrinkandroot.wicket.bootstrap.component.item

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.core.util.string.ComponentRenderer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AjaxLinkItemTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component: AjaxLinkItem<*> = object : AjaxLinkItem<Any?>("id", labelModel = "Label".model()) {
            override fun onClick(target: AjaxRequestTarget?) {
                /* Noop */
            }
        }
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id"><wicket:panel>
    <a href="#" wicket:id="link" id="link1">Label</a>
    <wicket:child/>
</wicket:panel></wicket:container>""", componentMarkup.toString()
        )
    }
}