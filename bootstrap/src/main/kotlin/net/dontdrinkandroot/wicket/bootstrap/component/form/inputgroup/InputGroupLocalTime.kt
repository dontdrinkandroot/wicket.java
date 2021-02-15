package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import net.dontdrinkandroot.wicket.component.form.LocalTimeTextField
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.model.IModel
import java.time.LocalTime

open class InputGroupLocalTime(id: String, model: IModel<LocalTime>? = null) :
    InputGroup<LocalTime, LocalTime, LocalTimeTextField>(id, model) {

    override fun createFormComponent(id: String): LocalTimeTextField {
        val formComponent: LocalTimeTextField = object : LocalTimeTextField(id, this.model) {
            override fun onComponentTag(tag: ComponentTag) {
                tag.put("type", "time")
                super.onComponentTag(tag)
            }
        }
        formComponent.add(HTML5Attributes())
        return formComponent
    }
}