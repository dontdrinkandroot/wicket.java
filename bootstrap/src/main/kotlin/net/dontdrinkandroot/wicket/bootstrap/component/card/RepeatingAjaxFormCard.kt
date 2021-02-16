package net.dontdrinkandroot.wicket.bootstrap.component.card

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.form.RepeatingAjaxForm
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.Heading
import org.apache.wicket.Component
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

open class RepeatingAjaxFormCard<T>(id: String, model: IModel<T>?, private var titleModel: IModel<String>) :
    RepeatingAjaxForm<T>(id, model) {

    private var headingLevel = Heading.Level.H2

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.CARD))
        val title = Heading("title", titleModel, headingLevel)
        this.add(title)
    }

    fun setHeadingLevel(headingLevel: Heading.Level): RepeatingAjaxFormCard<T> {
        this.headingLevel = headingLevel
        return this
    }

    override fun createActionsView(id: String): Component {
        val actionsView = RepeatingView(id)
        populateActions(actionsView)
        return actionsView
    }
}