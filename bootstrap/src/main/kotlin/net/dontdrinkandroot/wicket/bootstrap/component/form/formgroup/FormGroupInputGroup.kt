package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.form.FormComponent
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the Model Object.
 * @param <M> Type of the Form Component Model Object.
 * @param <F> Type of the [FormComponent]
 * @param <I> Type of the [InputGroup]
 */
abstract class FormGroupInputGroup<T, M, F : FormComponent<M>, I : InputGroup<T, M, F>>(
    id: String,
    model: IModel<T>,
    labelModel: IModel<String>
) : FormGroupValidatable<T, M, F>(id, model, labelModel) {

    private val inputGroup: InputGroup<T, M, F>

    override val formComponent: F
        get() = inputGroup.formComponent

    init {
        inputGroup = createInputGroup("inputGroup")
        inputGroup.add(CssClassAppender(BootstrapCssClass.HAS_VALIDATION))
        formComponent.label = this.labelModel
    }

    override fun addComponents() {
        super.addComponents()
        container.add(inputGroup)
    }

    protected open fun createInputGroupPrepend(id: String): Component = WebMarkupContainer(id).setVisible(false)

    protected open fun createInputGroupAppend(id: String): Component = WebMarkupContainer(id).setVisible(false)

    protected abstract fun createInputGroup(id: String): InputGroup<T, M, F>
}