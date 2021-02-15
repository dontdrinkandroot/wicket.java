package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.util.*

class FormGroupAutoCompleteTest : AbstractWicketTest() {

    @Test
    @Disabled("Strange component markup error, move to tag tester")
    fun testMarkup() {
        val component: FormGroupAutoComplete = object : FormGroupAutoComplete("id", Model("ExampleLabel"), Model()) {
            override fun getChoices(input: String): List<String> {
                return Arrays.asList("Alpha", "Beta", "Gamma")
            }
        }
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id" id="id1" class="form-group dropdown autocomplete"><wicket:panel>
		<label wicket:id="label" class="control-label" for="formComponent2">ExampleLabel</label>
		
			<wicket:child><wicket:extend>
		<wicket:child><wicket:extend>
    <input type="text" wicket:id="formComponent" class="form-control dropdown-toggle" autocomplete="off" value="" name="id:container:formComponent" id="formComponent2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenu" wicket:id="dropdownMenu" id="dropdownMenu3">
        <li wicket:id="suggestionItem">
            <a wicket:id="link" id="link4" href="javascript:;">Alpha</a>
        </li><li wicket:id="suggestionItem">
            <a wicket:id="link" id="link5" href="javascript:;">Beta</a>
        </li><li wicket:id="suggestionItem">
            <a wicket:id="link" id="link6" href="javascript:;">Gamma</a>
        </li>
    </ul>
</wicket:extend></wicket:child>
		<div id="helpBlock7" style="display:none"></div>
	</wicket:extend></wicket:child>
		
	</wicket:panel></wicket:container>""",
            componentMarkup.toString()
        )
    }
}