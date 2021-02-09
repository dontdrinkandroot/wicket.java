package net.dontdrinkandroot.wicket.model.time.temporal

import net.dontdrinkandroot.wicket.model.AbstractChainedModel
import org.apache.wicket.Component
import org.apache.wicket.model.IComponentAssignedModel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.IWrapModel
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor
import java.util.*

class DateTimeFormatterModel : AbstractChainedModel<TemporalAccessor, String>, IComponentAssignedModel<String> {

    private var pattern: String? = null
    private var zoneId: ZoneId? = null
    private var locale: Locale? = null

    constructor(parent: IModel<out TemporalAccessor>) : super(parent)

    constructor(parent: IModel<out TemporalAccessor>, pattern: String) : super(parent) {
        this.pattern = pattern
    }

    constructor(parent: IModel<out TemporalAccessor>, pattern: String, zoneId: ZoneId) : super(parent) {
        this.pattern = pattern
        this.zoneId = zoneId
    }

    override fun getValue(parentValue: TemporalAccessor?): String? = parentValue?.let { getValue(it, locale) }

    private fun getValue(parentValue: TemporalAccessor?, locale: Locale?): String {
        if (null == pattern) {
            return parentValue.toString()
        }
        var dateTimeFormatter = DateTimeFormatter.ofPattern(pattern)
        if (null != locale) {
            dateTimeFormatter = dateTimeFormatter.withLocale(locale)
        }
        if (null != zoneId) {
            dateTimeFormatter = dateTimeFormatter.withZone(zoneId)
        }
        return dateTimeFormatter.format(parentValue)
    }

    override fun wrapOnAssignment(component: Component): IWrapModel<String?> {
        return AssignmentWrapper(component)
    }

    fun setLocale(locale: Locale?): DateTimeFormatterModel {
        this.locale = locale
        return this
    }

    private inner class AssignmentWrapper(private val component: Component) : IWrapModel<String?> {

        override fun getObject(): String {
            return this@DateTimeFormatterModel.getValue(
                this@DateTimeFormatterModel.parent.getObject(),
                component.locale
            )
        }

        override fun getWrappedModel(): IModel<*> {
            return this@DateTimeFormatterModel
        }

        override fun detach() {
            this@DateTimeFormatterModel.detach()
        }
    }
}