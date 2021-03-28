package net.dontdrinkandroot.wicket.component.form

import net.dontdrinkandroot.wicket.converter.LocalDateTimeConverter
import org.apache.wicket.model.IModel
import org.apache.wicket.util.convert.IConverter
import java.time.LocalDateTime

open class LocalDateTimeTextField(id: String, model: IModel<LocalDateTime>? = null) :
    AbstractTemporalAccessorTextField<LocalDateTime>(id, model, LocalDateTime::class.java) {

    override fun createConverter(type: Class<*>): IConverter<*>? {
        return if (LocalDateTime::class.java.isAssignableFrom(type)) {
            LocalDateTimeConverter()
        } else null
    }

    override fun getInputTypes(): Array<String> = arrayOf("text", "datetime-local")
}