package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalTime

class FormGroupLocalTimeTest : AbstractWicketTest() {

    @Test
    fun testFullMarkup() {
        val formPanel = TestFormPanel("id")
        val formGroupLocalTime = FormGroupLocalTime("formGroup", Model("Label"), Model.of(LocalTime.of(13, 37)))
        formGroupLocalTime.formComponent.setMin(LocalTime.of(9, 13, 14))
        formGroupLocalTime.formComponent.setMax(LocalTime.of(17, 12))
        formPanel.form.add(formGroupLocalTime)
        val componentMarkup = ComponentRenderer.renderComponent(formGroupLocalTime)
        val formComponentTester =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent")
        Assertions.assertTrue(formComponentTester.getAttributeContains("class", "form-control"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("type", "time"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("value", "13:37"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("min", "09:13"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("max", "17:12"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("placeholder", "Label"))
    }
}