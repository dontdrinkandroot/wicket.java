package net.dontdrinkandroot.wicket.bootstrap.component.modal

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FormModalTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val component: FormModal<String> = object : FormModal<String>("modalId") {
            override fun createHeadingModel(): IModel<String> {
                return Model.of("Modal Heading")
            }
        }
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        var tester: TagTester
        tester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "modalId")
        Assertions.assertTrue(tester.getAttributeContains("class", "modal"))
        Assertions.assertTrue(tester.getAttributeContains("class", "fade"))
        tester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "heading")
        Assertions.assertEquals("Modal Heading", tester.value)
    }
}