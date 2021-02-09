package net.dontdrinkandroot.wicket.bootstrap.component.form

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormContainerSizeBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormLabelSizeBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormRowBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.model.CssClassToggleModel
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

open class FormGroup<T> : GenericPanel<T> {

    protected lateinit var labelModel: IModel<String?>

    private val labelScreenReaderOnlyModel = false.model()

    protected lateinit var label: Component

    protected lateinit var container: WebMarkupContainer

    constructor(id: String?) : super(id) {
        this.labelModel = Model(null)
    }

    constructor(id: String?, labelModel: IModel<String?>) : super(id) {
        this.labelModel = labelModel
    }

    constructor(id: String?, labelModel: IModel<String?>, model: IModel<T>?) : super(id, model) {
        this.labelModel = labelModel
    }

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
        label.add(CssClassAppender(BootstrapCssClass.CONTROL_LABEL))
        return label
    }

    protected fun createContainer(id: String): WebMarkupContainer {
        return WebMarkupContainer(id)
    }

    fun setLabelScreenReaderOnly(labelScreenReaderOnly: Boolean): FormGroup<T> {
        labelScreenReaderOnlyModel.setObject(labelScreenReaderOnly)
        return this
    }
}