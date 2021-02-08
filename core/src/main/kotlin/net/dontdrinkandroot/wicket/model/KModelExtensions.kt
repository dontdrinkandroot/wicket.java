package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

fun <T> T.kModel() = KModel { this }

fun <T> IModel<T>.toKModel(): KModel<T> = object : KModel<T> {
    override fun getValue(): T = this.`object`

    override fun setValue(value: T) {
        this.`object` = value
    }

    override fun detach() {
        this.detach()
    }
}