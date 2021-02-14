package net.dontdrinkandroot.wicket.component.form

import net.dontdrinkandroot.wicket.converter.LocalTimeConverter
import org.apache.wicket.model.IModel
import org.apache.wicket.util.convert.IConverter
import java.time.LocalDate
import java.time.LocalTime

open class LocalTimeTextField(id: String, model: IModel<LocalTime>? = null) :
    AbstractTemporalAccessorTextField<LocalTime>(id, model, LocalTime::class.java) {

    override fun createConverter(type: Class<*>): IConverter<*>? {
        return if (LocalDate::class.java.isAssignableFrom(type)) {
            LocalTimeConverter()
        } else null
    }

    override fun getInputTypes(): Array<String> = arrayOf("text", "time")
}