package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.form.FormComponent
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

/**
 * @param <T> Type of the Model Object.
 * @param <M> Type of the FormComponent Model Object.
 * @param <F> Type of the FormComponent.
 */
abstract class InputGroup<T, M, F : FormComponent<M>> constructor(
    id: String,
    model: IModel<T>? = null,
) : GenericPanel<T>(id, model) {

    private lateinit var inputGroupPrepend: Component

    private lateinit var inputGroupAppend: Component

    val formComponent: F

    init {
        formComponent = createFormComponent("formComponent")
        formComponent.outputMarkupId = true
    }

    override fun onInitialize() {
        super.onInitialize()

        this.add(CssClassAppender(BootstrapCssClass.INPUT_GROUP))
        this.add(formComponent)

        inputGroupPrepend = createAddonPrepend(INPUT_GROUP_PREPEND_ID)
        this.add(inputGroupPrepend)

        inputGroupAppend = createAddonAppend(INPUT_GROUP_APPEND_ID)
        this.add(inputGroupAppend)
    }

    override fun onConfigure() {
        super.onConfigure()
        val hasAddon = inputGroupPrepend.isVisible || inputGroupAppend.isVisible
        this.renderBodyOnly = !hasAddon
    }

    protected open fun createAddonPrepend(id: String): Component = WebMarkupContainer(id).setVisible(false)

    protected open fun createAddonAppend(id: String): Component = WebMarkupContainer(id).setVisible(false)

    protected abstract fun createFormComponent(id: String): F

    companion object {

        const val INPUT_GROUP_PREPEND_ID = "inputGroupPrepend"
        const val INPUT_GROUP_APPEND_ID = "inputGroupAppend"
    }
}