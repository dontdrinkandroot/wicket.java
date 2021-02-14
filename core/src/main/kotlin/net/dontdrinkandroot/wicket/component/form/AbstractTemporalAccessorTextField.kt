package net.dontdrinkandroot.wicket.component.form

import org.apache.wicket.markup.ComponentTag
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import java.io.Serializable
import java.time.temporal.TemporalAccessor

open class AbstractTemporalAccessorTextField<T>(
    id: String,
    model: IModel<T>? = null,
    type: Class<T>? = null,
    private val minModel: IModel<T> = Model(),
    private val maxModel: IModel<T> = Model()
) :
    TextField<T>(id, model, type) where T : TemporalAccessor, T : Serializable {

    fun setMin(min: T) {
        minModel.setObject(min)
    }

    fun setMax(max: T) {
        maxModel.setObject(max)
    }

    override fun onComponentTag(tag: ComponentTag) {
        super.onComponentTag(tag)
        val converter = getConverter(this.type)
        val attributes = tag.attributes
        val min = minModel.getObject()
        if (min != null) {
            attributes["min"] = converter.convertToString(min, this.locale)
        } else {
            attributes.remove("min")
        }
        val max = maxModel.getObject()
        if (max != null) {
            attributes["max"] = converter.convertToString(max, this.locale)
        } else {
            attributes.remove("max")
        }
    }
}