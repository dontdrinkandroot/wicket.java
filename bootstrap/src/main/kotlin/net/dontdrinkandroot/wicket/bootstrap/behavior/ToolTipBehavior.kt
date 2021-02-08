package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.model.EnumLowerCaseNameModel
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.kModel
import org.apache.wicket.AttributeModifier
import org.apache.wicket.Component
import org.apache.wicket.markup.head.IHeaderResponse
import org.apache.wicket.markup.head.OnDomReadyHeaderItem
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class ToolTipBehavior constructor(
    textModel: IModel<String>,
    private val positionModel: KModel<Position> = Position.TOP.kModel(),
    delayModel: IModel<Int> = Model.of(0)
) : CompositeBehavior(
    AttributeModifier("title", textModel),
    AttributeModifier("data-toggle", "tooltip"),
    AttributeModifier("data-placement", EnumLowerCaseNameModel(positionModel)),
    AttributeModifier("data-delay", delayModel)
) {

    override fun renderHead(component: Component, response: IHeaderResponse) {
        super.renderHead(component, response)
        response.render(OnDomReadyHeaderItem.forScript("$('[data-toggle=\"tooltip\"]').tooltip();"))
    }

    fun setPosition(position: Position): ToolTipBehavior {
        positionModel.setObject(position)
        return this
    }

    enum class Position {
        TOP, BOTTOM, LEFT, RIGHT
    }
}