package net.dontdrinkandroot.wicket.model

import java.text.SimpleDateFormat
import java.util.*

class SimpleDateFormatModel : AbstractChainedModel<Date, String> {

    // TODO: Maybe refactor this into an IComponentAssignedModel in order to use the locale of the attached component.
    private val simpleDateFormat: SimpleDateFormat

    constructor(parent: KModel<Date>, pattern: String) : super(parent) {
        simpleDateFormat = SimpleDateFormat(pattern)
    }

    constructor(parent: KModel<Date>, pattern: String, locale: Locale) : super(parent) {
        simpleDateFormat = SimpleDateFormat(pattern, locale)
    }

    override fun getValue(parentValue: Date) = simpleDateFormat.format(parentValue)
}