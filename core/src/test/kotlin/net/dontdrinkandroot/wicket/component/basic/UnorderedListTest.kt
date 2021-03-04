package net.dontdrinkandroot.wicket.component.basic

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.test.TestPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.util.ListModel
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UnorderedListTest : AbstractWicketTest() {

    @Test
    fun testDefault() {
        val page: TestPage = object : TestPage() {
            override fun populateComponents(componentView: RepeatingView) {
                componentView.add(unorderedList(
                    componentView.newChildId(),
                    ListModel(listOf("Alpha", "Beta", "Gamma"))
                ) { id, model -> Label(id, model) })
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