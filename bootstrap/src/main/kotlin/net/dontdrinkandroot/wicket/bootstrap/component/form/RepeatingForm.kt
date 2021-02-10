package net.dontdrinkandroot.wicket.bootstrap.component.form

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupActions
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize
import org.apache.wicket.Component
import org.apache.wicket.IQueueRegion
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.markup.html.panel.IMarkupSourcingStrategy
import org.apache.wicket.markup.html.panel.PanelMarkupSourcingStrategy
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the Model object.
 */
open class RepeatingForm<T>(id: String, model: IModel<T>? = null) : Form<T>(id, model), IQueueRegion {

    private val formStyleBehavior = FormStyleBehavior()

    lateinit var feedbackPanel: FeedbackPanel
        private set

    override fun onInitialize() {
        super.onInitialize()
        this.add(formStyleBehavior)
        feedbackPanel = FencedFeedbackPanel("feedback", this)
        feedbackPanel.outputMarkupId = true
        this.add(feedbackPanel)
        val formGroupView = RepeatingView("formGroup")
        populateFormGroups(formGroupView)
        this.add(formGroupView)
        val formGroupActions = createActionsView("actions")
        this.add(formGroupActions)
    }

    protected open fun createActionsView(id: String): Component {
        return object : FormGroupActions<Void>(id) {
            override fun populateActions(actionView: RepeatingView) {
                this@RepeatingForm.populateActions(actionView)
            }
        }
    }

    override fun newMarkupSourcingStrategy(): IMarkupSourcingStrategy {
        return PanelMarkupSourcingStrategy(false)
    }

    override fun onComponentTag(tag: ComponentTag) {
        tag.name = "form"
        super.onComponentTag(tag)
    }

    protected open fun populateFormGroups(formGroupView: RepeatingView) {
        /* Hook */
    }

    protected open fun populateActions(buttonView: RepeatingView) {
        /* Hook */
    }

    fun setHorizontal(containerSize: ColumnSize): RepeatingForm<T> {
        formStyleBehavior.setHorizontal(containerSize)
        return this
    }

    fun setInline(inline: Boolean): RepeatingForm<T> {
        formStyleBehavior.isInline = inline
        return this
    }
}