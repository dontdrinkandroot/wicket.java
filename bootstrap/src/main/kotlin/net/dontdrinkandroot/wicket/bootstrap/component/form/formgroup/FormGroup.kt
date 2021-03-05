package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormContainerSizeBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormLabelSizeBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormRowBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

open class FormGroup<T>(id: String, model: IModel<T>, protected var labelModel: IModel<String>) :
    GenericPanel<T>(id, model) {

    private val labelScreenReaderOnlyModel = Model(false)

    protected lateinit var label: Component

    protected lateinit var container: WebMarkupContainer

    override fun onInitialize() {
        super.onInitialize()
        this.outputMarkupId = true
        this.add(CssClassAppender(BootstrapCssClass.FORM_GROUP))
        createComponents()
        addComponents()
        addBehaviors()
    }

    protected open fun createComponents() {
        label = createLabel("label")
        container = createContainer("container")
    }

    protected open fun addComponents() {
        this.add(label)
        this.add(container)
    }

    protected open fun addBehaviors() {
        this.add(FormRowBehavior())
        label.add(FormLabelSizeBehavior())
        container.add(FormContainerSizeBehavior())
    }

    protected open fun createLabel(id: String): Component {
        val label = Label(id, labelModel)
        label.add(CssClassAppender(CssClassToggleModel(BootstrapCssClass.SR_ONLY, labelScreenReaderOnlyModel)))
        label.add(CssClassAppender(BootstrapCssClass.FORM_LABEL))
        return label
    }

    protected fun createContainer(id: String): WebMarkupContainer = WebMarkupContainer(id)

    fun setLabelScreenReaderOnly(labelScreenReaderOnly: Boolean): FormGroup<T> {
        labelScreenReaderOnlyModel.setObject(labelScreenReaderOnly)
        return this
    }
}