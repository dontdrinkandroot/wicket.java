package net.dontdrinkandroot.wicket.component.form

import net.dontdrinkandroot.wicket.converter.LocalDateConverter
import org.apache.wicket.model.IModel
import org.apache.wicket.util.convert.IConverter
import java.time.LocalDate

open class LocalDateTextField(id: String, model: IModel<LocalDate>? = null) :
    AbstractTemporalAccessorTextField<LocalDate>(id, model, LocalDate::class.java) {

    override fun createConverter(type: Class<*>): IConverter<*>? {
        return if (LocalDate::class.java.isAssignableFrom(type)) {
            LocalDateConverter()
        } else null
    }

    override fun getInputTypes(): Array<String> = arrayOf("text", "date")
}