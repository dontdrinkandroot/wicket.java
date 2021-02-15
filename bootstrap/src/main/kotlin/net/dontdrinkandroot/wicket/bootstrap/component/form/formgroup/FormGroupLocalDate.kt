package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupLocalDate
import net.dontdrinkandroot.wicket.component.form.LocalDateTextField
import org.apache.wicket.Component
import org.apache.wicket.model.IModel
import java.time.LocalDate

open class FormGroupLocalDate(id: String, model: IModel<LocalDate>, labelModel: IModel<String>) :
    FormGroupInputGroup<LocalDate, LocalDate, LocalDateTextField, InputGroupLocalDate>(id, labelModel, model) {

    override fun createInputGroup(id: String): InputGroup<LocalDate, LocalDate, LocalDateTextField> {
        return object : InputGroupLocalDate(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupLocalDate.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupLocalDate.createInputGroupAppend(id)
            }
        }
    }
}