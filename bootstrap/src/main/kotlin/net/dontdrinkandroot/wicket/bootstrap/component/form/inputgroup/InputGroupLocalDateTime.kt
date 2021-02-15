package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import net.dontdrinkandroot.wicket.component.form.LocalDateTimeTextField
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.model.IModel
import java.time.LocalDateTime

open class InputGroupLocalDateTime(id: String, model: IModel<LocalDateTime>? = null) :
    InputGroup<LocalDateTime, LocalDateTime, LocalDateTimeTextField>(id, model) {

    override fun createFormComponent(id: String): LocalDateTimeTextField {
        val formComponent: LocalDateTimeTextField = object : LocalDateTimeTextField(id, this.model) {
            override fun onComponentTag(tag: ComponentTag) {
                tag.put("type", "datetime-local")
                super.onComponentTag(tag)
            }
        }
        formComponent.add(HTML5Attributes())
        return formComponent
    }
}