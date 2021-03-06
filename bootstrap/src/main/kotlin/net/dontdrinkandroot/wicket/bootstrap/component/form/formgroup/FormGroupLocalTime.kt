package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupLocalTime
import net.dontdrinkandroot.wicket.component.form.LocalTimeTextField
import org.apache.wicket.Component
import org.apache.wicket.model.IModel
import java.time.LocalTime

class FormGroupLocalTime(id: String, model: IModel<LocalTime>, labelModel: IModel<String>) :
    FormGroupInputGroup<LocalTime, LocalTime, LocalTimeTextField, InputGroupLocalTime>(id, model, labelModel) {

    override fun createInputGroup(id: String): InputGroup<LocalTime, LocalTime, LocalTimeTextField> {
        return object : InputGroupLocalTime(id, model) {
            override fun createAddonPrepend(id: String): Component {
                return this@FormGroupLocalTime.createInputGroupPrepend(id)
            }

            override fun createAddonAppend(id: String): Component {
                return this@FormGroupLocalTime.createInputGroupAppend(id)
            }
        }
    }
}