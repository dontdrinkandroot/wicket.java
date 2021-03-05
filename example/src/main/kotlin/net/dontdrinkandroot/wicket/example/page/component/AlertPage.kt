package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.behavior.AlertBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class AlertPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun onInitialize() {
        super.onInitialize()
        val alertView = RepeatingView("alert")
        this.add(alertView)
        for (style in AlertStyle.values()) {
            val label = Label(alertView.newChildId(), Model.of(style.name.toLowerCase()))
            label.add(AlertBehavior(style))
            alertView.add(label)
        }
    }

    override fun onBeforeRender()
    {
        super.onBeforeRender()
        info("Info Message")
        debug("Debug message")
        success("Success Message")
        warn("Warn Message")
        this.error("Error Message")
        fatal("Fatal Message")
    }

    override fun createPageHeadingModel() = Model("Alerts and Feedback")
}