package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup

import net.dontdrinkandroot.wicket.component.form.LocalDateTextField
import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.HTML5Attributes
import org.apache.wicket.model.IModel
import java.time.LocalDate

open class InputGroupLocalDate(id: String, model: IModel<LocalDate>? = null) :
    InputGroup<LocalDate, LocalDate, LocalDateTextField>(id, model) {

    override fun createFormComponent(id: String): LocalDateTextField {
        val formComponent: LocalDateTextField = object : LocalDateTextField(id, this.model) {
            override fun onComponentTag(tag: ComponentTag) {
                tag.put("type", "date")
                super.onComponentTag(tag)
            }
        }
        formComponent.add(HTML5Attributes())
        return formComponent
    }
}