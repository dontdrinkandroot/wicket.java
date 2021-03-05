package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.css.StringCssClass
import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CssClassAppenderTest : AbstractWicketTest() {

    @Test
    fun testStringConstructor() {
        val container = WebMarkupContainer("id")
        container.add(CssClassAppender("testone"))
        val componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id" class="testone"></wicket:container>""",
            componentMarkup.toString()
        )
    }

    @Test
    fun testCssClassConstructor() {
        val container = WebMarkupContainer("id")
        container.add(CssClassAppender(StringCssClass("testone")))
        val componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id" class="testone"></wicket:container>""",
            componentMarkup.toString()
        )
    }

    @Test
    fun testModelConstructor() {
        val classModel: IModel<CssClass> = Model(StringCssClass("testone"))
        val container = WebMarkupContainer("id")
        container.add(CssClassAppender(classModel))
        var componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id" class="testone"></wicket:container>""",
            componentMarkup.toString()
        )
        classModel.setObject(StringCssClass("testtwo"))
        componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            """<wicket:container wicket:id="id" class="testtwo"></wicket:container>""",
            componentMarkup.toString()
        )
    }
}