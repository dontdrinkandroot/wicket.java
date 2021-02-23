package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import org.apache.wicket.model.LoadableDetachableModel
import org.apache.wicket.model.Model
import java.io.Serializable

fun <T : Serializable?> T.model(): IModel<T> = Model(this)

var <T> IModel<T>.value: T?
    get() = `object`
    set(value) {
        `object` = value
    }

@Suppress("UNCHECKED_CAST")
fun <T> IModel<T>.nullable(): IModel<T?> = this as IModel<T?>

fun <T> (() -> T).ldm(): LoadableDetachableModel<T> = LoadableDetachableModel.of(this)

fun String.concat(model: IModel<String>): IModel<String> =
    object : AbstractChainedModel<String, String>(model) {
        override fun getValue(parentValue: String?) = this@concat + parentValue
    }

fun <T, V> IModel<T>.isValue(value: V) = object : AbstractChainedModel<T, Boolean>(this) {
    override fun getValue(parentValue: T?) = parentValue == value
}

fun <T, V> IModel<T>.isNotValue(value: V): IModel<Boolean> = object : AbstractChainedModel<T, Boolean>(this) {
    override fun getValue(parentValue: T?) = parentValue != value
}

fun <T> IModel<T>.isNotPresent() = object : AbstractChainedModel<T, Boolean>(this) {
    override fun getValue(parentValue: T?) = parentValue == null
}

fun <T> IModel<List<T>>.joinToString(
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((T) -> CharSequence)? = null
) = object : AbstractChainedModel<List<T>, String>(this) {
    override fun getValue(parentValue: List<T>?): String? =
        parentValue?.joinToString(separator, prefix, postfix, limit, truncated, transform)
}

fun IModel<String>.capitalize() = object : AbstractChainedModel<String, String>(this) {
    override fun getValue(parentValue: String?) = parentValue?.capitalize()
}