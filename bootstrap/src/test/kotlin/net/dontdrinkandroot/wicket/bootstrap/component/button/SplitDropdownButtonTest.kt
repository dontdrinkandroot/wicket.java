package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.Component
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SplitDropdownButtonTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component: SplitDropdownButton<String> = object : SplitDropdownButton<String>("id") {
            override fun createAction(id: String): Component {
                return Label(id, "ActionLabel")
            }

            override fun populateItems(itemView: RepeatingView) {}
        }
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id" class="btn-group"><wicket:panel>
		<button wicket:id="button" type="button" class="btn btn-secondary">ActionLabel</button>
		<button wicket:id="toggle" type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<span class="sr-only">Toggle Dropdown</span>
		<span class="caret"></span></button>
		<ul wicket:id="dropdownMenu" class="dropdown-menu" role="menu"><wicket:panel>
    
</wicket:panel></ul>
	</wicket:panel></wicket:container>""",
            componentMarkup.toString()
        )
    }
}