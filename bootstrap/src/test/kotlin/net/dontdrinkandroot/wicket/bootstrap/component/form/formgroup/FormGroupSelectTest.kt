package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.model.util.ListModel
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FormGroupSelectTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val formPanel = TestFormPanel("id")
        val formGroupSelect = FormGroupSelect(
            "formGroup",
            Model.of("alpha"),
            Model("Label"),
            ListModel(listOf("alpha", "beta", "gamma"))
        )
        formPanel.form.add(formGroupSelect)
        val componentMarkup = ComponentRenderer.renderComponent(formPanel)
        val formGroupTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup")
        Assertions.assertTrue(formGroupTester.getAttributeContains("class", "form-group"))
        val labelTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "label")
        Assertions.assertTrue(labelTester.getAttributeContains("class", "form-label"))
        val formComponentTester =
            TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent")
        Assertions.assertTrue(formComponentTester.getAttributeContains("class", "form-control"))
        Assertions.assertEquals(
            """<select class="form-control" wicket:id="formComponent" name="formGroup:container:formComponent" id="formComponent3">
<option selected="selected" value="0">alpha</option>
<option value="1">beta</option>
<option value="2">gamma</option>
</select>""",
            formComponentTester.markup
        )
        val helpBlockTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "helpBlock")
        Assertions.assertNull(helpBlockTester)
    }
}