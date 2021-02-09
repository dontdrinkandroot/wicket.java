package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import java.text.SimpleDateFormat
import java.util.*

class SimpleDateFormatModel : AbstractChainedModel<Date, String> {

    // TODO: Maybe refactor this into an IComponentAssignedModel in order to use the locale of the attached component.
    private val simpleDateFormat: SimpleDateFormat

    constructor(parent: IModel<Date>, pattern: String) : super(parent) {
        simpleDateFormat = SimpleDateFormat(pattern)
    }

    constructor(parent: IModel<Date>, pattern: String, locale: Locale) : super(parent) {
        simpleDateFormat = SimpleDateFormat(pattern, locale)
    }

    override fun getValue(parentValue: Date?) = simpleDateFormat.format(parentValue)
}