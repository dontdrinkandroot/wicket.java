package net.dontdrinkandroot.wicket.component.basic

import net.dontdrinkandroot.wicket.component.basic.Heading
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.WicketTestCase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HeadingTest : WicketTestCase() {

    @Test
    fun testMarkup() {
        var heading: Heading
        var markup: String

        //        heading = new Heading("id", Heading.Level.H1);
        //        markup = ComponentRenderer.renderComponent(heading).toString();
        //        Assertions.assertEquals("<wicket:h1 wicket:id=\"id\"></wicket:h1>", markup);
        heading = Heading("id", "Heading2", Heading.Level.H2)
        markup = ComponentRenderer.renderComponent(heading).toString()
        Assertions.assertEquals("<wicket:h2 wicket:id=\"id\">Heading2</wicket:h2>", markup)
        heading = Heading("id", Model("Heading3"), Heading.Level.H3)
        markup = ComponentRenderer.renderComponent(heading).toString()
        Assertions.assertEquals("<wicket:h3 wicket:id=\"id\">Heading3</wicket:h3>", markup)
    }
}