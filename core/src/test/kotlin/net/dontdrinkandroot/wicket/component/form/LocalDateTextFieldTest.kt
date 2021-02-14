package net.dontdrinkandroot.wicket.component.form

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.test.InputTestPage
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

class LocalDateTextFieldTest : AbstractWicketTest() {

    @Test
    fun testBasicAttributes() {
        val component = LocalDateTextField("id", Model.of(LocalDate.of(2017, 2, 3)))
        component.outputMarkupId = true
        component.setMin(LocalDate.of(2017, 1, 1))
        component.setMax(LocalDate.of(2018, 12, 31))
        component.isRequired = true
        component.add(HTML5Attributes())
        val page = InputTestPage(component, "date")
        tester.startPage(page)
        val tagTester = tester.getTagById(component.markupId)
        Assertions.assertNotNull(tagTester)
        Assertions.assertEquals("2017-02-03", tagTester.getAttribute("value"))
        Assertions.assertEquals("2017-01-01", tagTester.getAttribute("min"))
        Assertions.assertEquals("2018-12-31", tagTester.getAttribute("max"))
        Assertions.assertEquals("required", tagTester.getAttribute("required"))
    }
}