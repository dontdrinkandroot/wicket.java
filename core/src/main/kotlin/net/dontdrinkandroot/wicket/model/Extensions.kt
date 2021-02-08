package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import org.apache.wicket.model.LoadableDetachableModel
import org.apache.wicket.model.Model
import java.io.Serializable

fun <T : Serializable?> T.model(): IModel<T?> = Model.of(this)

fun <T> (() -> T).ldm(): LoadableDetachableModel<T?> = LoadableDetachableModel.of(this)

fun String.concat(model: KModel<String>): KModel<String> =
    object : AbstractChainedModel<String, String>(model) {
        override fun getValue(parentValue: String) = this@concat + parentValue
    }

fun <T, V> KModel<T>.isValue(value: V) = object : AbstractChainedModel<T, Boolean>(this) {
    override fun getValue(parentValue: T) = parentValue == value
}

fun <T, V> KModel<T>.isNotValue(value: V): IModel<Boolean> = object : AbstractChainedModel<T, Boolean>(this) {
    override fun getValue(parentValue: T) = parentValue != value
}

fun <T> KModel<T>.isNotPresent() = object : AbstractChainedModel<T, Boolean>(this) {
    override fun getValue(parentValue: T) = parentValue == null
}

fun <T> KModel<List<T>>.joinToString(
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((T) -> CharSequence)? = null
) = object : AbstractChainedModel<List<T>, String>(this) {
    override fun getValue(parentValue: List<T>): String =
        parentValue.joinToString(separator, prefix, postfix, limit, truncated, transform)
}

fun KModel<String>.capitalize() = object : AbstractChainedModel<String, String>(this) {
    override fun getValue(parentValue: String) = parentValue.capitalize()
}