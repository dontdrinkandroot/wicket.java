package net.dontdrinkandroot.wicket.kmodel

import org.apache.wicket.IGenericComponent
import org.apache.wicket.model.IModel
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.time.temporal.TemporalAccessor
import java.util.*
import kotlin.reflect.KFunction1
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

fun <T : Any?> T.kModel() = ValueKModel(this)

@Suppress("UNCHECKED_CAST")
fun <T> KModel<T>.nullable(): KModel<T?> = this as KModel<T?>

interface KModel<T> : IModel<T> {

    val value: T

    override fun getObject(): T = value
    override fun setObject(value: T): Unit = throw UnsupportedOperationException("Readonly")
}

interface WriteableKModel<T> : KModel<T> {

    override var value: T

    override fun setObject(value: T) {
        this.value = `object`
    }
}

class ValueKModel<T>(override var value: T) : WriteableKModel<T>

class WrappedKModel<T>(private val model: IModel<T>) : WriteableKModel<T> {

    override var value: T
        get() = model.getObject()
        set(value) {
            model.setObject(value)
        }
}

fun <T> IModel<T>.wrap(): WriteableKModel<T> = WrappedKModel(this)

fun <T, P> KModel<T>.writableProperty(kMutableProperty1: KMutableProperty1<T, P>): WriteableKModel<P> =
    object : WriteableKModel<P> {
        override var value: P
            get() = kMutableProperty1.getValue(this@writableProperty.value, kMutableProperty1)
            set(value) = kMutableProperty1.set(this@writableProperty.value, value)

        override fun detach() {
            this@writableProperty.detach()
        }
    }

fun <T> KModel<T?>.default(defaultValue: T) = object : KModel<T> {
    override val value: T
        get() = this@default.value ?: defaultValue

    override fun detach() {
        this@default.detach()
    }
}

fun <T, P> KModel<T>.property(kProperty1: KProperty1<T, P>): KModel<P> = object : KModel<P> {
    override val value: P
        get() = kProperty1.getValue(this@property.value, kProperty1)

    override fun detach() {
        this@property.detach()
    }
}

fun <T, P> KModel<T?>.optionalProperty(kProperty1: KProperty1<T, P>): KModel<P?> = object : KModel<P?> {
    override val value: P?
        get() = this@optionalProperty.value?.let { kProperty1.getValue(it, kProperty1) }

    override fun detach() {
        this@optionalProperty.detach()
    }
}

fun <P, T> KModel<P>.function(function: KFunction1<P, T>): KModel<T> = object : KModel<T> {
    override val value: T
        get() = function.invoke(this@function.value)

    override fun detach() {
        this@function.detach()
    }
}

val <T, C : IGenericComponent<T, *>> IGenericComponent<T, C>.kModel: KModel<T>
    get() = when (this.model) {
        null -> throw RuntimeException("Model was null")
        is WriteableKModel -> this.model as WriteableKModel<T>
        is KModel -> this.model as KModel<T>
        else -> WrappedKModel<T>(this.model)
    }

fun <T : String?> KModel<T>.capitalize(): KModel<String?> = object : KModel<String?> {
    override val value: String?
        get() = this@capitalize.value?.capitalize()

    override fun detach() {
        this@capitalize.detach()
    }
}

fun <T : TemporalAccessor?> KModel<T>.formatDate(
    formatStyle: FormatStyle,
    locale: Locale = Locale.ENGLISH,
    zoneId: ZoneId = ZoneId.from(ZoneOffset.UTC)
): KModel<String?> = object : KModel<String?> {
    override var value: String?
        get() = this@formatDate.value?.let {
            DateTimeFormatter.ofLocalizedDateTime(formatStyle).withLocale(locale).withZone(zoneId).format(it)
        }
        set(value) = throw UnsupportedOperationException("Readonly")

}

fun <T, L : List<T>?> KModel<L>.joinToString(
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((T) -> CharSequence)? = null
): KModel<String?> = object : KModel<String?> {
    override var value: String?
        get() = this@joinToString.value?.joinToString(separator, prefix, postfix, limit, truncated, transform)
        set(value) = throw UnsupportedOperationException("Readonly")

    override fun detach() {
        this@joinToString.detach()
    }
}