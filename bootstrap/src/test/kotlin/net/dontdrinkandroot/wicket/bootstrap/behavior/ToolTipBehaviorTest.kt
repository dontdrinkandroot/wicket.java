package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ToolTipBehaviorTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val container = WebMarkupContainer("id")
        container.add(ToolTipBehavior(Model("TestText")))
        val componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" title=\"TestText\" data-toggle=\"tooltip\" data-placement=\"top\" data-delay=\"0\"></wicket:container>",
            componentMarkup.toString()
        )
    }

    @Test
    fun testPosition() {
        val container = WebMarkupContainer("id")
        val behavior = ToolTipBehavior(Model.of("TestText"))
        container.add(behavior)
        var tagTester: TagTester
        var componentMarkup: String
        val positionModel: IModel<ToolTipBehavior.Position> = Model()
        positionModel.setObject(ToolTipBehavior.Position.TOP)
        componentMarkup = ComponentRenderer.renderComponent(container).toString()
        tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        tagTester.getAttributeIs("data-placement", "top")
        positionModel.setObject(ToolTipBehavior.Position.RIGHT)
        componentMarkup = ComponentRenderer.renderComponent(container).toString()
        tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        tagTester.getAttributeIs("data-placement", "right")
        positionModel.setObject(ToolTipBehavior.Position.BOTTOM)
        componentMarkup = ComponentRenderer.renderComponent(container).toString()
        tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        tagTester.getAttributeIs("data-placement", "bottom")
        positionModel.setObject(ToolTipBehavior.Position.LEFT)
        componentMarkup = ComponentRenderer.renderComponent(container).toString()
        tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id")
        tagTester.getAttributeIs("data-placement", "left")
    }
}