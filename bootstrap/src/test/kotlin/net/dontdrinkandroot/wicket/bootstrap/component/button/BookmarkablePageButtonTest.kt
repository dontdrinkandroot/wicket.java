package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.bootstrap.test.getTestApplication
import org.apache.wicket.Page
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BookmarkablePageButtonTest : AbstractWicketTest() {

    @Test
    fun testMarkup() {
        val component: BookmarkablePageButton<Any, *> =
            object : BookmarkablePageButton<Any, Page>("id", getTestApplication().homePage) {
                override fun onComponentTag(tag: ComponentTag) {
                    tag.name = "a"
                    super.onComponentTag(tag)
                }
            }
        component.body = Model.of("Label")
        val componentMarkup = ComponentRenderer.renderComponent(component).toString()
        Assertions.assertEquals(
            "<wicket:a wicket:id=\"id\" href=\"./\" class=\"btn btn-secondary\">Label</wicket:a>",
            componentMarkup
        )
    }
}