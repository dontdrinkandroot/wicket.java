package net.dontdrinkandroot.wicket.component.basic

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.test.TestPage
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.util.ListModel
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class UnorderedListTest : AbstractWicketTest() {

    @Test
    fun testDefault() {
        val page: TestPage = object : TestPage() {
            override fun populateComponents(componentView: RepeatingView) {
                val component: UnorderedList<String> = object : UnorderedList<String>(
                    componentView.newChildId(),
                    ListModel(Arrays.asList("Alpha", "Beta", "Gamma"))
                ) {
                    override fun createListComponent(id: String, model: IModel<String>): Component {
                        return Label(id, model)
                    }
                }
                componentView.add(component)
            }
        }
        tester.startPage(page)
        val pageMarkup: CharSequence = tester.lastResponseAsString
        val componentTester = TagTester.createTagByAttribute(pageMarkup.toString(), "wicket:id", "component")
        val componentMarkup = componentTester.markup
        Assertions.assertEquals(
            """<ul wicket:id="component"><wicket:panel>
		<li wicket:id="item">Alpha</li><li wicket:id="item">Beta</li><li wicket:id="item">Gamma</li>
	</wicket:panel></ul>""", componentMarkup
        )
    }
}