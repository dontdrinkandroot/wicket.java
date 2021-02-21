package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupLocalDateTime
import net.dontdrinkandroot.wicket.component.form.LocalDateTimeTextField
import org.apache.wicket.Component
import org.apache.wicket.model.IModel
import java.time.LocalDateTime

class FormGroupLocalDateTime(id: String, model: IModel<LocalDateTime>, labelModel: IModel<String>) :
    FormGroupInputGroup<LocalDateTime, LocalDateTime, LocalDateTimeTextField, InputGroupLocalDateTime>(
        id,
        model,
        labelModel
    ) {

    override fun createInputGroup(id: String): InputGroup<LocalDateTime, LocalDateTime, LocalDateTimeTextField> {
        return object : InputGroupLocalDateTime(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupLocalDateTime.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupLocalDateTime.createInputGroupAppend(id)
            }
        }
    }
}