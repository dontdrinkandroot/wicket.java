package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class ButtonGroupChoiceTest : AbstractWicketTest() {

    @Test
    fun testDefault() {
        val choices = Arrays.asList("Alpha", "Beta", "Gamma")
        val component = ButtonGroupChoice("id", Model.of("Beta"), choices)
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id" id="id1" class="btn-group"><wicket:panel>
		<a href="#" wicket:id="choice" class="btn btn btn-secondary" id="id12">Alpha</a><a href="#" wicket:id="choice" class="btn btn btn-secondary active" id="id23">Beta</a><a href="#" wicket:id="choice" class="btn btn btn-secondary" id="id34">Gamma</a>
	</wicket:panel></wicket:container>""", componentMarkup.toString()
        )
    }
}