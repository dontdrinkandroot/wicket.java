package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class FormGroupLocalDateTimeTest : AbstractWicketTest() {

    @Test
    fun testFullMarkup() {
        val formPanel = TestFormPanel("id")
        val formGroupLocalDate = FormGroupLocalDateTime(
            "formGroup",
            Model("Label"),
            Model.of(LocalDateTime.of(2017, 1, 2, 3, 4))
        )
        formGroupLocalDate.formComponent.setMin(LocalDateTime.of(2016, 6, 4, 23, 46))
        formGroupLocalDate.formComponent.setMax(LocalDateTime.of(2018, 9, 6, 12, 53))
        formPanel.form.add(formGroupLocalDate)
        val componentMarkup = ComponentRenderer.renderComponent(formGroupLocalDate)
        val formComponentTester =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent")
        Assertions.assertEquals("form-control", formComponentTester.getAttribute("class"))
        Assertions.assertEquals("datetime-local", formComponentTester.getAttribute("type"))
        Assertions.assertEquals("2017-01-02T03:04", formComponentTester.getAttribute("value"))
        Assertions.assertEquals("2016-06-04T23:46", formComponentTester.getAttribute("min"))
        Assertions.assertEquals("2018-09-06T12:53", formComponentTester.getAttribute("max"))
        Assertions.assertEquals("Label", formComponentTester.getAttribute("placeholder"))
    }
}