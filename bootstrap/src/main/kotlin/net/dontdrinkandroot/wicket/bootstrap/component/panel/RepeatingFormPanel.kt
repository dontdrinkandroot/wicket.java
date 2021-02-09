package net.dontdrinkandroot.wicket.bootstrap.component.panel

import net.dontdrinkandroot.wicket.bootstrap.behavior.PanelBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.form.RepeatingForm
import net.dontdrinkandroot.wicket.component.basic.Heading
import org.apache.wicket.Component
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

open class RepeatingFormPanel<T>(id: String, private var titleModel: IModel<String>, model: IModel<T>?) :
    RepeatingForm<T>(id, model) {

    private val panelBehavior = PanelBehavior()
    private var headingLevel = Heading.Level.H2

    override fun onInitialize() {
        super.onInitialize()
        this.add(panelBehavior)
        val title = Heading("title", titleModel, headingLevel)
        this.add(title)
    }

    fun setHeadingLevel(headingLevel: Heading.Level): RepeatingFormPanel<T> {
        this.headingLevel = headingLevel
        return this
    }

    override fun createActionsView(id: String): Component {
        val actionsView = RepeatingView(id)
        populateActions(actionsView)
        return actionsView
    }
}