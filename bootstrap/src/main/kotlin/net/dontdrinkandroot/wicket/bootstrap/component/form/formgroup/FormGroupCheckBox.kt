package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.behavior.ForComponentIdBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormContainerSizeBehavior
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormLabelSizeBehavior
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.CheckBox
import org.apache.wicket.model.IModel

class FormGroupCheckBox(id: String, labelModel: IModel<String>, model: IModel<Boolean>) :
    FormGroupFormComponent<Boolean, Boolean, CheckBox>(id, model, labelModel) {

    private var offset: WebMarkupContainer? = null

    private lateinit var labelWrapper: WebMarkupContainer

    override fun createFormComponent(id: String): CheckBox = CheckBox(id, this.model)

    override fun createComponents() {
        super.createComponents()
        labelWrapper = WebMarkupContainer("labelWrapper")
        labelWrapper.add(ForComponentIdBehavior(formComponent))
        offset = WebMarkupContainer("offset")
    }

    override fun addComponents() {
        this.add(offset)
        this.add(container)
        container.add(labelWrapper)
        container.add(helpBlock)
        labelWrapper.add(label)
        labelWrapper.add(formComponent)
    }

    override fun createLabel(id: String): Component {
        return Label(id, labelModel)
    }

    override fun addBehaviors() {
        offset!!.add(FormLabelSizeBehavior())
        container.add(FormContainerSizeBehavior())
    }
}