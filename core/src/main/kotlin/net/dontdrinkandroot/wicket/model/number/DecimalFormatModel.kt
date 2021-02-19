package net.dontdrinkandroot.wicket.model.number

import net.dontdrinkandroot.wicket.model.AbstractChainedModel
import org.apache.wicket.model.IModel
import java.text.DecimalFormat
import java.util.*

class DecimalFormatModel<T : Number>(
    parentModel: IModel<T>,
    private var locale: Locale = Locale.ENGLISH,
    private var defaultIfNull: String? = "n/a"
) : AbstractChainedModel<T, String>(parentModel) {

    override fun getValue(parentValue: T?): String? {
        parentValue ?: return defaultIfNull
        return DecimalFormat.getNumberInstance(locale).format(parentValue)
    }
}

fun <T : Number> IModel<T>.formatDecimal(locale: Locale = Locale.ENGLISH, default: String = "n/a"): IModel<String> =
    DecimalFormatModel(this, locale, default)
