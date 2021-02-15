package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

class FormGroupLocalDateTest : AbstractWicketTest() {

    @Test
    fun testFullMarkup() {
        val formPanel = TestFormPanel("id")
        val testDate = LocalDate.of(2016, 3, 4)
        val minDate = LocalDate.of(2015, 1, 2)
        val maxDate = LocalDate.of(2017, 5, 6)
        val formGroupLocalDate = FormGroupLocalDate("formGroup", Model("Label"), Model.of(testDate))
        formGroupLocalDate.formComponent.setMin(minDate)
        formGroupLocalDate.formComponent.setMax(maxDate)
        formPanel.form.add(formGroupLocalDate)
        val componentMarkup = ComponentRenderer.renderComponent(formGroupLocalDate)
        val formComponentTester =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent")
        Assertions.assertTrue(formComponentTester.getAttributeContains("class", "form-control"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("type", "date"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("value", "2016-03-04"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("min", "2015-01-02"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("max", "2017-05-06"))
        Assertions.assertTrue(formComponentTester.getAttributeContains("placeholder", "Label"))
    }
}