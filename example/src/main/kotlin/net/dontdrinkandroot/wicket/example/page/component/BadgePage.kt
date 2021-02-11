package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.behavior.BadgeBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class BadgePage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Badges".model()

    override fun onInitialize() {
        super.onInitialize()

        val badgeView = RepeatingView("badge")
        this.add(badgeView)

        for (style in BadgeStyle.values()) {
            val label = Label(badgeView.newChildId(), Model.of(style.name))
            label.add(BadgeBehavior(style))
            badgeView.add(label)
        }
    }
}