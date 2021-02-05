package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TitleModifierTest : AbstractWicketTest() {

    @Test
    fun testStringConstructor() {
        val container = WebMarkupContainer("id")
        container.add(TitleModifier("testone"))
        val componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id" title="testone"></wicket:container>""",
            componentMarkup.toString()
        )
    }

    @Test
    fun testModelConstructor() {
        val classModel: IModel<String> = Model.of("testone")
        val container = WebMarkupContainer("id")
        container.add(TitleModifier(classModel))
        var componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" title=\"testone\"></wicket:container>",
            componentMarkup.toString()
        )
        classModel.setObject("testtwo")
        componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" title=\"testtwo\"></wicket:container>",
            componentMarkup.toString()
        )
    }
}