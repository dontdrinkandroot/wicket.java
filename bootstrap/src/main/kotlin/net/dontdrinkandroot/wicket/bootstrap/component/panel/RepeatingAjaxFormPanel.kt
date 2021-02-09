package net.dontdrinkandroot.wicket.bootstrap.component.panel

import net.dontdrinkandroot.wicket.bootstrap.behavior.PanelBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.form.RepeatingAjaxForm
import net.dontdrinkandroot.wicket.component.basic.Heading
import net.dontdrinkandroot.wicket.model.KModel
import org.apache.wicket.Component
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

open class RepeatingAjaxFormPanel<T>(id: String, model: IModel<T>?, private var titleModel: KModel<String>) :
    RepeatingAjaxForm<T>(id, model) {

    private val panelBehavior = PanelBehavior()
    private var headingLevel = Heading.Level.H2

    override fun onInitialize() {
        super.onInitialize()
        this.add(panelBehavior)
        val title = Heading("title", titleModel, headingLevel)
        this.add(title)
    }

    fun setHeadingLevel(headingLevel: Heading.Level): RepeatingAjaxFormPanel<T> {
        this.headingLevel = headingLevel
        return this
    }

    override fun createActionsView(id: String): Component {
        val actionsView = RepeatingView(id)
        populateActions(actionsView)
        return actionsView
    }
}