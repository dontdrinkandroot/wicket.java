package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemView
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DropdownButtonTest : AbstractWicketTest() {

    @Test
    fun testDefault() {
        val component: DropdownButton<Void> = object : DropdownButton<Void>("id", null, Model.of("LabelText")) {
            override fun populateItems(itemView: ItemView) {}
        }
        val componentMarkup = ComponentRenderer.renderComponent(component)
        val componentTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id")
        Assertions.assertTrue(componentTester.getAttributeContains("class", "dropdown"))
        val toggleTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "toggle")
        Assertions.assertEquals(
            """<button wicket:id="toggle" type="button" class="dropdown-toggle btn btn-secondary" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">LabelText</button>""",
            toggleTester.markup
        )
        val menuTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "menu")
        Assertions.assertEquals(
            """<ul wicket:id="menu" class="dropdown-menu" role="menu"><wicket:panel>
    
</wicket:panel></ul>""", menuTester.markup
        )
    }
}