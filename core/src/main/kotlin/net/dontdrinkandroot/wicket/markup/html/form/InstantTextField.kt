package net.dontdrinkandroot.wicket.markup.html.form

import net.dontdrinkandroot.wicket.converter.InstantConverter
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.IModel
import org.apache.wicket.util.convert.IConverter
import java.time.Instant
import java.time.ZoneId

class InstantTextField(id: String, model: IModel<Instant?>, private val zoneId: ZoneId) :
    TextField<Instant>(id, model, Instant::class.java) {

    override fun createConverter(type: Class<*>?): IConverter<*> = InstantConverter(zoneId)

    override fun getInputTypes() = arrayOf("text", "datetime-local")
}
