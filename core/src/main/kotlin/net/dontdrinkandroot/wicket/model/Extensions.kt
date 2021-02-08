package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import org.apache.wicket.model.LoadableDetachableModel
import org.apache.wicket.model.Model
import java.io.Serializable

var <T> IModel<T?>.value: T?
    get() = `object`
    set(value) {
        `object` = value
    }

fun <T : Serializable?> T.model(): IModel<T?> = Model.of(this)

fun <T> (() -> T).ldm(): LoadableDetachableModel<T?> = LoadableDetachableModel.of(this)

fun String.concat(model: IModel<String?>): IModel<String?> =
    object : AbstractChainedReadonlyModel<String, String>(model) {
        override fun getObject(): String = this@concat + getParentModelObject()
    }

fun <T, V> IModel<T?>.isValue(value: V) = object : AbstractChainedModel<T, Boolean>(this) {
    override fun getObject(): Boolean = getParentModelObject() == value
}

fun <T, V> IModel<T?>.isNotValue(value: V): IModel<Boolean?> = object : AbstractChainedModel<T, Boolean>(this) {
    override fun getObject(): Boolean = getParentModelObject() != value
}

fun <T> IModel<T?>.isNotPresent() = object : AbstractChainedModel<T, Boolean>(this) {
    override fun getObject(): Boolean = getParentModelObject() == null
}

fun <T> IModel<List<T>?>.joinToString(
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((T) -> CharSequence)? = null
) = object : AbstractChainedReadonlyModel<List<T>?, String?>(this) {
    override fun getObject(): String? =
        getParentModelObject()?.joinToString(separator, prefix, postfix, limit, truncated, transform)
}

fun IModel<String?>.capitalize() = object : AbstractChainedReadonlyModel<String?, String?>(this) {
    override fun getObject(): String? = getParentModelObject()?.capitalize()
}