package net.dontdrinkandroot.wicket.bootstrap.component.form

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RepeatingFormTest : AbstractWicketTest() {

    @Test
    fun testPlainMarkup() {
        val component = RepeatingForm<Void>("id")
        val componentMarkup = ComponentRenderer.renderComponent(component)
        Assertions.assertEquals(
            """<wicket:form wicket:id="id" id="id1" method="post" action="./wicket/page?0-0.-id"><wicket:panel>
		<div wicket:id="feedback" id="feedback2"><wicket:panel>
		
	</wicket:panel></div>
		
		<div wicket:id="actions" id="actions3" class="form-group"><wicket:panel>
		<label wicket:id="label" class="control-label"></label>
		<div wicket:id="container">
			<wicket:child><wicket:extend>
    <div class="btn-toolbar">
        
    </div>
</wicket:extend></wicket:child>
		</div>
	</wicket:panel></div>
	</wicket:panel></wicket:form>""",
            componentMarkup.toString()
        )
    }
}